package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

//患者费用明细
public class PatientCosts {
    private Integer id;//患者费用明细主键ID
    private Integer invoiceid;//发票主键ID
    private Integer registerid;//挂号主键ID
    private String name;//项目名称
    private BigDecimal price;//项目价格
    private String deptid;//执行科室名称
    private Integer state;//状态
    // 1 - 未交费
    // 2 - 已交费

    @JsonIgnore
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}