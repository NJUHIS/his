package com.njuhis.his.model;

import java.util.Date;

/**
 * 一次挂号
 */
public class Register {
    private Integer id;//本次挂号主键ID
    private String realname;//患者真实姓名
    private Integer gender; //患者性别
    private String idnumber;//患者身份证号码
    private Date birthdate;//患者出生日期
    private Integer age;//患者年龄
    private Integer agetype;//患者年龄类型
    private String homeaddress;//患者家庭住址
    private Date visitdate;//本次看诊日期
    private Integer noon;//本次看诊午别
    //1 - 凌晨
    //2 - 早上
    //3 - 下午
    //4 - 晚上

    private Integer patientid;//患者用户主键ID
    private Integer deptid;//科室主键ID
    private Integer userid;//医生用户主键ID
    private Integer settleid;//结算类型主键ID

    private Integer isbook;//是否需要病历本
    //1-需要
    //0-不需要

    private Integer registertime;//挂号时间。毫秒數。
    private Integer registerid;//挂号员用户主键ID
    private Integer registerLevelId;//挂号级别主键ID

    private Integer visitstate;

    private String casenumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgetype() {
        return agetype;
    }

    public void setAgetype(Integer agetype) {
        this.agetype = agetype;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRegisterLevelId() {
        return registerLevelId;
    }

    public void setRegisterLevelId(Integer registerLevelId) {
        this.registerLevelId = registerLevelId;
    }

    public Integer getSettleid() {
        return settleid;
    }

    public void setSettleid(Integer settleid) {
        this.settleid = settleid;
    }

    public Integer getIsbook() {
        return isbook;
    }

    public void setIsbook(Integer isbook) {
        this.isbook = isbook;
    }

    public Integer getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Integer registertime) {
        this.registertime = registertime;
    }

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public Integer getVisitstate() {
        return visitstate;
    }

    public void setVisitstate(Integer visitstate) {
        this.visitstate = visitstate;
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }
}