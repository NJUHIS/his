package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

//挂号类型
public class RegisterLevel {
    private Integer id;//挂号类型主键ID，即挂号级别编码
    private String registname;//挂号类型名称
    //如普通号、专家号、急诊号等。
    private BigDecimal registfee;//挂号类型价格









    @JsonIgnore
    private Integer delmark;//删除标记 1-是 0-否


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getRegistname() {
        return registname;
    }

    public void setRegistname(String registname) {
        this.registname = registname == null ? null : registname.trim();
    }


    public BigDecimal getRegistfee() {
        return registfee;
    }

    public void setRegistfee(BigDecimal registfee) {
        this.registfee = registfee;
    }


    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}