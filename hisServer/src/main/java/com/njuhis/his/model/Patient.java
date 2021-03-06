package com.njuhis.his.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//患者
public class Patient {
    private Integer id;//患者主键ID
    private String name;//患者真实姓名
    private String idnumber;//患者身份证号
    private String phone;//患者手机号
    private String loginname;//患者登陆名
    private String password;//患者密码
    private String homeAddress;//家庭住址
    private Integer gender;//性別。1-男 2-女 3-其他
    private Date birthday;//生日


    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone="GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}