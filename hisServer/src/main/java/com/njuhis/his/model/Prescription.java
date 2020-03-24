package com.njuhis.his.model;

public class Prescription {
    private Integer id;

    private Integer medicalId;

    private Integer userId;

    private String prescriptionName;

    private Integer prescriptionState;

    private Integer prescriptionTime;

    private String invoiceId;

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