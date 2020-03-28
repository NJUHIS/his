package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//科室
public class Department {
    private Integer id;//科室主键ID
    private String deptname;//科室名称
    private String deptcategory;//科室分类
    private Integer depttypeid;//科室类型
    private String deptcode;//科室编码





    @JsonIgnore
    private Integer delmark;//删除标记 1-是 0-否

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