package com.njuhis.his.service;

import com.njuhis.his.datacleaner.RegistrationDataCleaner;
import com.njuhis.his.mapper.InvoiceMapper;
import com.njuhis.his.mapper.PatientCostsMapper;
import com.njuhis.his.mapper.RegisterMapper;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RegistrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private PatientCostsMapper patientCostsMapper;
    @Autowired
    private RegistrationDataCleaner registrationDataCleaner;
    @Autowired
    private UtilityService utilityService;
    @Autowired
    private BasicInformationService basicInformationService;
    @Autowired
    private PersonalInformationService personalInformationService;
    @Autowired
    private DoctorService doctorService;


    public Register addRegistration(Register registration, ResultMessage resultMessage){

        //數據清洗
        registrationDataCleaner.cleanRegistration(registration,resultMessage);if(!resultMessage.isSuccessful()) return null;

        /**
         * 通过 scheduleId 来填写 deptid, userid, visitdate,noon,registrationtypeid。
         */
        Scheduling scheduling=basicInformationService.getSchedulingById(registration.getScheduleId(),resultMessage);if(!resultMessage.isSuccessful()) return null;

        if(scheduling.getUser().getUsertypeid()!=2){
            resultMessage.sendClientError("Not a clinic doctor. 不是一位门诊医生。");
            return null;
        }

        if(scheduling.getRemainingQuota()<=0){
            resultMessage.sendClientError("Fully booked. Not enough quota. 挂号已满，配额不足。");
            return null;
        }

        registration.setUserid(scheduling.getUserid());
        registration.setDeptid(scheduling.getUser().getDeptid());
        registration.setVisitdate(scheduling.getScheddate());
        registration.setNoon(scheduling.getNoon());
        registration.setRegistid(scheduling.getUser().getRegisterLevelId());

        registration.setVisitstate(0);//看診狀態為 未看診。
        registration.setRegistertime(new Date().getTime());//掛號的時間。


        Patient patient=personalInformationService.getPatientById(registration.getPatientid(),resultMessage);if(!resultMessage.isSuccessful()) return null;
        registration.setBirthdate(patient.getBirthday());
        registration.setHomeaddress(patient.getHomeAddress());
        registration.setGender(patient.getGender());
        registration.setRealname(patient.getName());
        registration.setIdnumber(patient.getIdnumber());

        scheduling.setRemainingQuota(scheduling.getRemainingQuota()-1);

        Invoice invoice=new Invoice();
        invoice.setState(1);    // 1 - 未开出
        invoice.setDailystate(1);    // 1 - 未日结审核

        PatientCosts patientCosts=new PatientCosts();
        patientCosts.setName("Registration Expense 挂号费");
        patientCosts.setPrice(new BigDecimal(9999));
        patientCosts.setState(2);// 2 - 已交费


        try {
            registerMapper.insert(registration);
            basicInformationService.updateScheduling(scheduling,resultMessage);if(!resultMessage.isSuccessful()) return null;
            invoice.setId(registration.getId());
            patientCosts.setInvoiceid(invoice.getId());
            patientCosts.setRegisterid(registration.getId());
            addInvoice(invoice,resultMessage);if(!resultMessage.isSuccessful()) return null;
            addPatientCosts(patientCosts,resultMessage);if(!resultMessage.isSuccessful()) return null;

        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;

        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getRegistrationById(registration.getId(),resultMessage);

    }


    public Register getRegistrationById(Integer id, ResultMessage resultMessage){
        Register registration=registerMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(registration!=null){
            return registration;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.REGISTRATION_NOT_EXIST);
            return null;
        }

    }

    public Register updateRegistration(Register registration, ResultMessage resultMessage){
        getRegistrationById(registration.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                registerMapper.updateByPrimaryKey(registration);
                return getRegistrationById(registration.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public Invoice addInvoice(Invoice invoice,ResultMessage resultMessage){
            try {
                invoiceMapper.insert(invoice);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
            return getInvoiceById(invoice.getId(),resultMessage);
    }


    public Invoice getInvoiceById(Integer id, ResultMessage resultMessage){
        Invoice invoice=invoiceMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(invoice!=null){
            return invoice;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.INVOICE_NOT_EXIST);
            return null;
        }

    }


    public Invoice updateInvoice(Invoice invoice, ResultMessage resultMessage){
        getInvoiceById(invoice.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                invoiceMapper.updateByPrimaryKey(invoice);
                return getInvoiceById(invoice.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public PatientCosts addPatientCosts(PatientCosts patientCosts, ResultMessage resultMessage){
        try {
            patientCostsMapper.insert(patientCosts);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getPatientCostsById(patientCosts.getId(),resultMessage);
    }


    public PatientCosts getPatientCostsById(Integer id, ResultMessage resultMessage){
        PatientCosts patientCosts=patientCostsMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(patientCosts!=null){
            return patientCosts;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.INVOICE_DETAIL_NOT_EXIST);
            return null;
        }

    }


    public PatientCosts updatePatientCosts(PatientCosts patientCosts, ResultMessage resultMessage){
        getPatientCostsById(patientCosts.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                patientCostsMapper.updateByPrimaryKey(patientCosts);
                return getPatientCostsById(patientCosts.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public List<Register> getRegistrationsByConditions(
            Date fromVisitDate,
            Integer fromNoon,
            Date toVisitDate,
            Integer toNoon,
            Integer departmentId,
            Integer userId,
            Integer registrationTypeId,
            Integer settlementTypeId,
            Integer needBook,
            Integer registrarId,
            Integer visitState,
            Integer patientId,
            Integer scheduleId,
            ResultMessage resultMessage

    ){
        if(fromVisitDate==null&&fromNoon!=null||fromVisitDate!=null&&fromNoon==null){
            resultMessage.sendClientError("\'From Appointment Date\' and \'From Noon\' are invalid. 「起始预约日期」和「起始预约午别」无效。" );
            return null;
        }

        if(toVisitDate==null&&toNoon!=null||toVisitDate!=null&&toNoon==null){
            resultMessage.sendClientError("\'To Appointment Date\' and \'To Noon\' are invalid. 「结束预约日期」和「结束预约午别」无效。" );
            return null;
        }

        if(fromVisitDate==null){
            fromVisitDate=new Date(1901-1900, 6-1, 12); //1901-06-12
            fromNoon=1;
        }

        if(toVisitDate==null){
            toVisitDate=new Date(2201-1900, 6-1, 12); //2201-06-12
            toNoon=4;
        }


        List<Register> registrations=registerMapper.selectAll();
        List<Register> filteredRegistrations=new ArrayList<>();

        for(Register registration:registrations){
            if ((departmentId == null || departmentId.equals(registration.getDeptid()))
                    && (scheduleId==null||scheduleId.equals(registration.getScheduleId()))
                    && (userId == null || userId.equals(registration.getUserid()))
                    && (visitState == null || visitState.equals(registration.getVisitstate()))
                    &&(registrationTypeId==null||registrationTypeId.equals(registration.getRegistid()))
                    &&(settlementTypeId==null||settlementTypeId.equals(registration.getSettleid()))
                    &&(registrarId==null||registrarId.equals(registration.getRegisterid()))
                    &&(needBook==null||needBook.equals(registration.getIsbook()))
                    &&(patientId==null||patientId.equals(registration.getPatientid()))
                    && (fromVisitDate.compareTo(registration.getVisitdate())<0
                    ||fromVisitDate.compareTo(registration.getVisitdate())==0&&fromNoon<=registration.getNoon())
                    &&(toVisitDate.compareTo(registration.getVisitdate())>0
                    ||toVisitDate.compareTo(registration.getVisitdate())==0&&toNoon>=registration.getNoon())
            ) {
                filteredRegistrations.add(registration);

            }

        }
        return filteredRegistrations;
    }


    public CheckApply payCheckApply(Integer checkApplyId, ResultMessage resultMessage){
        CheckApply checkApply=doctorService.getCheckApplyById(checkApplyId,resultMessage);if(!resultMessage.isSuccessful())return null;

        if(checkApply.getState()!=2){//如果不是 2-已开立并发出，未收费
            resultMessage.sendClientError("The state is not 2. 状态不是 2-已开出未收费");
            return null;
        }

        checkApply.setState(3);// 3 - 已收费，未检验检查处置

        PatientCosts patientCosts=new PatientCosts();
        patientCosts.setName("Test (Examination or Disposal) Expense 检验（检查或处置）费用");
        patientCosts.setPrice(checkApply.getTotalSum());
        patientCosts.setState(2);// 2 - 已交费
        patientCosts.setRegisterid(checkApply.getMedicalId());
        patientCosts.setInvoiceid(checkApply.getMedicalId());
        Invoice invoice=getInvoiceById(checkApply.getMedicalId(),resultMessage);if(!resultMessage.isSuccessful())return null;
        invoice.setMoney(invoice.getMoney().add(patientCosts.getPrice()));

        checkApply=doctorService.updateCheckApplyInternal(checkApply,resultMessage);if(!resultMessage.isSuccessful())return null;
        addPatientCosts(patientCosts,resultMessage);if(!resultMessage.isSuccessful())return null;
        updateInvoice(invoice,resultMessage);if(!resultMessage.isSuccessful())return null;

        return checkApply;
    }

    public Prescription payPrescription(Integer prescriptionId, ResultMessage resultMessage){
        Prescription prescription=doctorService.getPrescriptionById(prescriptionId,resultMessage);if(!resultMessage.isSuccessful())return null;

        if(prescription.getPrescriptionState()!=2){//如果不是 2 - 已确认并发出，未收费。
            resultMessage.sendClientError("The state is not 2. 状态不是 2-已开出未收费");
            return null;
        }

        prescription.setPrescriptionState(3);// 3 - 已收费，未取药。


        BigDecimal sum=new BigDecimal(0);
        for(PrescriptionDetailed prescriptionDetailed:prescription.getPrescriptionDetailedList()){
            sum=sum.add(prescriptionDetailed.getPrice());
        }

        PatientCosts patientCosts=new PatientCosts();
        patientCosts.setName("Drug Expense 药品费用");
        patientCosts.setPrice(sum);
        patientCosts.setState(2);// 2 - 已交费
        patientCosts.setRegisterid(prescription.getId());
        patientCosts.setInvoiceid(prescription.getId());

        Invoice invoice=getInvoiceById(prescriptionId,resultMessage);if(!resultMessage.isSuccessful())return null;
        invoice.setMoney(invoice.getMoney().add(patientCosts.getPrice()));

        prescription=doctorService.updatePrescriptionInternal(prescription,resultMessage);if(!resultMessage.isSuccessful())return null;
        addPatientCosts(patientCosts,resultMessage);if(!resultMessage.isSuccessful())return null;
        return prescription;
    }

    public Invoice confirmInvoice(Integer invoiceId, ResultMessage resultMessage){
        Invoice invoice=getInvoiceById(invoiceId,resultMessage);if(!resultMessage.isSuccessful())return null;

        if(invoice.getState()!=1){//如果不是 1 - 未开出
            resultMessage.sendClientError("The state is not 1. 状态不是 1 - 未开出。");
            return null;
        }

        // 1 - 未开出
        // 2 - 已开出，正常状态

        invoice.setState(2);// 2 - 已开出，正常状态

        invoice.setCreationtime(new Date().getTime());//开立时间。

        invoice= updateInvoice(invoice,resultMessage);if(!resultMessage.isSuccessful())return null;

        return invoice;
    }

}





