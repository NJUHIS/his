package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//常数项
public class ConstantItem {
    private Integer id;//常数项主键ID
    private Integer constanttypeid;//常数类型主键ID
    private String constantcode;//常数项编码
    private String constantname;//常数项名称








    @JsonIgnore
    private Integer delmark;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConstanttypeid() {
        return constanttypeid;
    }

    public void setConstanttypeid(Integer constanttypeid) {
        this.constanttypeid = constanttypeid;
    }

    public String getConstantcode() {
        return constantcode;
    }

    public void setConstantcode(String constantcode) {
        this.constantcode = constantcode == null ? null : constantcode.trim();
    }

    public String getConstantname() {
        return constantname;
    }

    public void setConstantname(String constantname) {
        this.constantname = constantname == null ? null : constantname.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}