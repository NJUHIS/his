package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//诊断
public class Diagnosis {
    private Integer id;//诊断主键ID
    private Integer medicalid;//病历主键ID
    private Integer diseaseid;//疾病主键ID
    private Disease disease;




    /**
     * @deprecated
     */
    @JsonIgnore
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(Integer medicalid) {
        this.medicalid = medicalid;
    }

    public Integer getDiseaseid() {
        return diseaseid;
    }

    public void setDiseaseid(Integer diseaseid) {
        this.diseaseid = diseaseid;
    }

    /**
     * @deprecated
     */
    public Integer getState() {
        return state;
    }

    /**
     * @deprecated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}