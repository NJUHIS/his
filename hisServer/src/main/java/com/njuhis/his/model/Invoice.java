package com.njuhis.his.model;

import java.math.BigDecimal;
import java.util.List;

//发票
public class Invoice {
    private Integer id;//发票ID
    private String invoicenum;//发票编码
    private BigDecimal money;//发票金额
    private Integer state;//发票状态
    // 1 - 未开出
    // 2 - 已开出，正常状态
    // 3 - 已作废
    // 4 - 此发票作为红冲
    private Long creationtime;// 生效时间。以确认开立的时间为准。毫秒数。
    private Integer userid;//开立人员主键ID
    private Integer dailystate;//日结审核状态
    // 1 - 未日结审核
    // 2 - 已日结审核
    private List<PatientCosts> patientCostsList; //发票明细的列表


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoicenum() {
        return invoicenum;
    }

    public void setInvoicenum(String invoicenum) {
        this.invoicenum = invoicenum == null ? null : invoicenum.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Long creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDailystate() {
        return dailystate;
    }

    public void setDailystate(Integer dailystate) {
        this.dailystate = dailystate;
    }

    public List<PatientCosts> getPatientCostsList() {
        return patientCostsList;
    }

    public void setPatientCostsList(List<PatientCosts> patientCostsList) {
        this.patientCostsList = patientCostsList;
    }
}