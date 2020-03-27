package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class User {
    private Integer id;//用戶主键ID
    private String username;//登录名
    private String password;//密码
    private String realname;//真实姓名
    private Integer usertypeid;//用户类别标识
    // 1 - 挂号人员
    // 2 - 门诊医生
    // 3 - 医技医生
    // 4 - 药房人员
    // 5 - 财务人员
    // 6 - 行政人员

    private Integer doctitleid;//医生职称。
    // 1-主任医师
    // 2-副主任医师
    // 3-主治医师
    // 4-住院医师

    private Integer isscheduling;//是否排班 1-是 0-否
    private Integer deptid;//所在科室主键ID
    private Integer registid;//挂号级别主键ID
    private String idnumber;//身份证号

    @JsonIgnore
    private Integer delmark;//删除标记 1-是 0-否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(Integer usertypeid) {
        this.usertypeid = usertypeid;
    }

    public Integer getDoctitleid() {
        return doctitleid;
    }

    public void setDoctitleid(Integer doctitleid) {
        this.doctitleid = doctitleid;
    }

    public Integer getIsscheduling() {
        return isscheduling;
    }

    public void setIsscheduling(Integer isscheduling) {
        this.isscheduling = isscheduling;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getRegistid() {
        return registid;
    }

    public void setRegistid(Integer registid) {
        this.registid = registid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }
}