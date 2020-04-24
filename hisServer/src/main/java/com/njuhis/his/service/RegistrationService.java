package com.njuhis.his.service;

import com.njuhis.his.datacleaner.RegistrationDataCleaner;
import com.njuhis.his.mapper.InvoiceMapper;
import com.njuhis.his.mapper.PatientCostsMapper;
import com.njuhis.his.mapper.RegisterMapper;
import com.njuhis.his.model.Invoice;
import com.njuhis.his.model.PatientCosts;
import com.njuhis.his.model.Register;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.Registration;
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


    public Register addRegistration(Register registration, ResultMessage resultMessage){

        //數據清洗
        registrationDataCleaner.cleanRegistration(registration,resultMessage);
        if(!resultMessage.isSuccessful()) return null;

        registration.setVisitstate(0);//看診狀態為 未看診。
        registration.setRegistertime(new Date().getTime());//掛號的時間。

        try{
            registerMapper.insert(registration);
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }

        registration.setCasenumber(registration.getId().toString());//保存後設置病歷編碼。
        registration=updateRegistration(registration,resultMessage);

        return registration;

    }

    public Register getRegistrationById(Integer id, ResultMessage resultMessage){
        Register registration=registerMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(registration!=null){
            return registration;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.REGISTRATION_NOT_EXIST);
            return null;
        }

    }

    public Register updateRegistration(Register registration, ResultMessage resultMessage){
        getRegistrationById(registration.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                registerMapper.updateByPrimaryKey(registration);
                return getRegistrationById(registration.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public Invoice addInvoice(Invoice invoice,ResultMessage resultMessage){
            try {
                invoiceMapper.insert(invoice);
                return invoice;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
    }


    public Invoice getInvoiceById(Integer id, ResultMessage resultMessage){
        Invoice invoice=invoiceMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(invoice!=null){
            return invoice;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.INVOICE_NOT_EXIST);
            return null;
        }

    }


    public Invoice updateInvoice(Invoice invoice, ResultMessage resultMessage){
        getInvoiceById(invoice.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                invoiceMapper.updateByPrimaryKey(invoice);
                return getInvoiceById(invoice.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public PatientCosts addPatientCosts(PatientCosts patientCosts, ResultMessage resultMessage){
        try {
            patientCostsMapper.insert(patientCosts);
            return patientCosts;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public PatientCosts getPatientCostsById(Integer id, ResultMessage resultMessage){
        PatientCosts patientCosts=patientCostsMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(patientCosts!=null){
            return patientCosts;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.INVOICE_DETAIL_NOT_EXIST);
            return null;
        }

    }


    public PatientCosts updatePatientCosts(PatientCosts patientCosts, ResultMessage resultMessage){
        getPatientCostsById(patientCosts.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                patientCostsMapper.updateByPrimaryKey(patientCosts);
                return getPatientCostsById(patientCosts.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
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
            ResultMessage resultMessage
    ){
        if(fromVisitDate==null&&fromNoon!=null||fromVisitDate!=null&&fromNoon==null){
            resultMessage.setClientError("\'From Appointment Date\' and \'From Noon\' are invalid. 「起始预约日期」和「起始预约午别」无效。" );
            return null;
        }

        if(toVisitDate==null&&toNoon!=null||toVisitDate!=null&&toNoon==null){
            resultMessage.setClientError("\'To Appointment Date\' and \'To Noon\' are invalid. 「结束预约日期」和「结束预约午别」无效。" );
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

}





