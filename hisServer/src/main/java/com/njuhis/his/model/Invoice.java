package com.njuhis.his.model;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private Integer id;

    private String invoicenum;

    private BigDecimal money;

    private Integer state;

    private Date creationtime;

    private Integer userid;

    private Integer dailystate;

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

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
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
}