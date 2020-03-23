package com.njuhis.his.model;

public class ConstantType {
    private Integer id;

    private String constanttypecode;

    private String constanttypename;

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