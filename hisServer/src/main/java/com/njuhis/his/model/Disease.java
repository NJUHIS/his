package com.njuhis.his.model;

public class Disease {
    private Integer id;

    private String diseasecode;

    private String diseasename;

    private String diseaseicd;

    private String diseasetype;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseasecode() {
        return diseasecode;
    }

    public void setDiseasecode(String diseasecode) {
        this.diseasecode = diseasecode == null ? null : diseasecode.trim();
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename == null ? null : diseasename.trim();
    }

    public String getDiseaseicd() {
        return diseaseicd;
    }

    public void setDiseaseicd(String diseaseicd) {
        this.diseaseicd = diseaseicd == null ? null : diseaseicd.trim();
    }

    public String getDiseasetype() {
        return diseasetype;
    }

    public void setDiseasetype(String diseasetype) {
        this.diseasetype = diseasetype == null ? null : diseasetype.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}