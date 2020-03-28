package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//常数类型
public class ConstantType {
    private Integer id; //常数类型主键ID
    private String constanttypecode;//常数类型编码
    private String constanttypename;//常数类型名称

    @JsonIgnore
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstanttypecode() {
        return constanttypecode;
    }

    public void setConstanttypecode(String constanttypecode) {
        this.constanttypecode = constanttypecode == null ? null : constanttypecode.trim();
    }

    public String getConstanttypename() {
        return constanttypename;
    }

    public void setConstanttypename(String constanttypename) {
        this.constanttypename = constanttypename == null ? null : constanttypename.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}