package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//处方
public class Prescription {
    private Integer id;//处方主键ID
    private Integer medicalId;//病历主键ID
    private Integer userId;//开立医生用户主键ID
    private String prescriptionName;//处方名称
    private Integer prescriptionState;//处方状态
    //1 - 编辑中
    //2 - 已开立并发出，未收费。
    //3 - 已收费，未取药。
    //4 - 已取药。
    private Integer prescriptionTime;//开立时间。毫秒数。以开立发出时为准。
    private String invoiceId;//发票主键ID

    @JsonIgnore
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(Integer medicalId) {
        this.medicalId = medicalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName == null ? null : prescriptionName.trim();
    }

    public Integer getPrescriptionState() {
        return prescriptionState;
    }

    public void setPrescriptionState(Integer prescriptionState) {
        this.prescriptionState = prescriptionState;
    }

    public Integer getPrescriptionTime() {
        return prescriptionTime;
    }

    public void setPrescriptionTime(Integer prescriptionTime) {
        this.prescriptionTime = prescriptionTime;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}