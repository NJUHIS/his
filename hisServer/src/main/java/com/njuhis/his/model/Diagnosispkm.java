package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Diagnosispkm {
    private Integer id;//诊断主键ID
    private Integer medicalid;//病历主键ID
    private Integer drugid; //疾病主键ID



    /**
     * @deprecated
     */
    @JsonIgnore
    private Integer state; //诊断状态


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

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
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
}