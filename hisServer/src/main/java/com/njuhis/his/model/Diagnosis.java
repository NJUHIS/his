package com.njuhis.his.model;

public class Diagnosis {
    private Integer id;

    private Integer medicalid;

    private Integer diseaseid;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}