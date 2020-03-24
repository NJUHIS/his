package com.njuhis.his.model;

import java.util.Date;

public class Register {
    private Integer id;

    private String realname;

    private Integer gender;

    private String idnumber;

    private Date birthdate;

    private Integer age;

    private Integer agetype;

    private String homeaddress;

    private String casenumber;

    private Date visitdate;

    private Integer noon;

    private Integer deptid;

    private Integer userid;

    private Integer registid;

    private Integer settleid;

    private Integer isbook;

    private Integer registertime;

    private Integer registerid;

    private Integer visitstate;

    private Integer patientid;

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

    public Integer getRegistid() {
        return registid;
    }

    public void setRegistid(Integer registid) {
        this.registid = registid;
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