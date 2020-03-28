package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;

//费用类型
public class ExpenseClass {
    private Integer id;//费用类型主键ID
    private String expname;//费用类型名称
    private String expcode;//费用类型的编码

    @JsonIgnore
    private Integer delmark;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpcode() {
        return expcode;
    }

    public void setExpcode(String expcode) {
        this.expcode = expcode == null ? null : expcode.trim();
    }

    public String getExpname() {
        return expname;
    }

    public void setExpname(String expname) {
        this.expname = expname == null ? null : expname.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}