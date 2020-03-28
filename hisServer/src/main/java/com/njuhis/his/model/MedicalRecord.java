package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MedicalRecord {
    private Integer id;//病历的主键ID
    private Integer registerId;//挂号的主键ID
    private String medicalReadme;//主诉
    private String medicalPresent;//现病史
    private String presentTreat;//现病治疗情况
    private String medicalHistory;//既往史
    private String medicalAllergy;//过敏史
    private String medicalPhysique;//体格检查
    private String medicalDiagnosis;//诊断结果
    private String medicalHandling;//处理意见

    private Integer caseState;//病历状态
    // 1 - 已预约
    // 2 - 进行中
    // 3 - 已完成/诊毕；



    private String caseNumber;//病历编号

    @JsonIgnore
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;


    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber == null ? null : caseNumber.trim();
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public String getMedicalReadme() {
        return medicalReadme;
    }

    public void setMedicalReadme(String medicalReadme) {
        this.medicalReadme = medicalReadme == null ? null : medicalReadme.trim();
    }

    public String getMedicalPresent() {
        return medicalPresent;
    }

    public void setMedicalPresent(String medicalPresent) {
        this.medicalPresent = medicalPresent == null ? null : medicalPresent.trim();
    }

    public String getPresentTreat() {
        return presentTreat;
    }

    public void setPresentTreat(String presentTreat) {
        this.presentTreat = presentTreat == null ? null : presentTreat.trim();
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory == null ? null : medicalHistory.trim();
    }

    public String getMedicalAllergy() {
        return medicalAllergy;
    }

    public void setMedicalAllergy(String medicalAllergy) {
        this.medicalAllergy = medicalAllergy == null ? null : medicalAllergy.trim();
    }

    public String getMedicalPhysique() {
        return medicalPhysique;
    }

    public void setMedicalPhysique(String medicalPhysique) {
        this.medicalPhysique = medicalPhysique == null ? null : medicalPhysique.trim();
    }

    public String getMedicalDiagnosis() {
        return medicalDiagnosis;
    }

    public void setMedicalDiagnosis(String medicalDiagnosis) {
        this.medicalDiagnosis = medicalDiagnosis == null ? null : medicalDiagnosis.trim();
    }

    public String getMedicalHandling() {
        return medicalHandling;
    }

    public void setMedicalHandling(String medicalHandling) {
        this.medicalHandling = medicalHandling == null ? null : medicalHandling.trim();
    }

    public Integer getCaseState() {
        return caseState;
    }

    public void setCaseState(Integer caseState) {
        this.caseState = caseState;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}