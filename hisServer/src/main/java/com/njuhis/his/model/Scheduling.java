package com.njuhis.his.model;

//import com.sun.tools.corba.se.idl.IncludeGen;

import java.util.Date;

//排班
public class Scheduling {
    private Integer id;//排班主键ID
    private Date scheddate;//排班日期
    private Integer deptid;//被排班医生的所属部门主键ID
    private Integer userid;//被排班的医生的医院员工主键ID
    private Integer noon;//午别
    //1 - 凌晨
    //2 - 早上
    //3 - 下午
    //4 - 晚上

    private Integer registquota;//该医生在本次排班的挂号数量限额
    private Integer state;//排班的状态
    //1 - 已过期
    //2 - 正在进行中
    //3 - 未进行
    private User user; //被排班的医生
    private Department department;////被排班医生的所属部门








    public void setUser(User user) {
        this.user = user;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getScheddate() {
        return scheddate;
    }

    public void setScheddate(Date scheddate) {
        this.scheddate = scheddate;
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

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }


    public Integer getRegistquota() {
        return registquota;
    }

    public void setRegistquota(Integer registquota) {
        this.registquota = registquota;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}