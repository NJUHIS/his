package com.njuhis.his.model;

public class MedicalRecord {
    private Integer id;

    private String caseNumber;

    private Integer registerId;

    private String medicalReadme;

    private String medicalPresent;

    private String presentTreat;

    private String medicalHistory;

    private String medicalAllergy;

    private String medicalPhysique;

    private String medicalDiagnosis;

    private String medicalHandling;

    private Integer caseState;

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