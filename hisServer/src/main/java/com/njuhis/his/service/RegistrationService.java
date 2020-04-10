package com.njuhis.his.service;

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


@Service
public class RegistrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private PatientCostsMapper patientCostsMapper;


    public Register addRegistration(Register registration, ResultMessage resultMessage){
        try{
            registerMapper.insert(registration);
            return registration;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public Register getRegistrationById(Integer id, ResultMessage resultMessage){
        Register registration=registerMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(registration!=null){
            return registration;
        }else{
            resultMessage.setClientError(ResultMessage.REGISTRATION_NOT_EXIST);
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
            resultMessage.setClientError(ResultMessage.INVOICE_NOT_EXIST);
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
            resultMessage.setClientError(ResultMessage.INVOICE_DETAIL_NOT_EXIST);
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

}







/**



    public A addInvoice(A a,ResultMessage resultMessage){
        try {
            aMapper.insert(a);
            return a;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public A getAById(Integer id, ResultMessage resultMessage){
        A a=aMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(a!=null){
            return a;
        }else{
            resultMessage.setClientError(ResultMessage.A_NOT_EXIST);
            return null;
        }

    }


    public A updateA(A a, ResultMessage resultMessage){
        getAById(a.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                aMapper.updateByPrimaryKey(a);
                return getAById(a.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


 **/
