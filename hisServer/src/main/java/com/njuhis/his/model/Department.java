package com.njuhis.his.model;

public class Department {
    private Integer id;

    private String deptcode;

    private String deptname;

    private String deptcategory;

    private Integer depttypeid;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getDeptcategory() {
        return deptcategory;
    }

    public void setDeptcategory(String deptcategory) {
        this.deptcategory = deptcategory == null ? null : deptcategory.trim();
    }

    public Integer getDepttypeid() {
        return depttypeid;
    }

    public void setDepttypeid(Integer depttypeid) {
        this.depttypeid = depttypeid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}