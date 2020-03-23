package com.njuhis.his.model;

import java.math.BigDecimal;

public class RegisterLevel {
    private Integer id;

    private String registcode;

    private String registname;

    private Integer isdefault;

    private Integer sequence;

    private BigDecimal registfee;

    private Integer registquota;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistcode() {
        return registcode;
    }

    public void setRegistcode(String registcode) {
        this.registcode = registcode == null ? null : registcode.trim();
    }

    public String getRegistname() {
        return registname;
    }

    public void setRegistname(String registname) {
        this.registname = registname == null ? null : registname.trim();
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getRegistfee() {
        return registfee;
    }

    public void setRegistfee(BigDecimal registfee) {
        this.registfee = registfee;
    }

    public Integer getRegistquota() {
        return registquota;
    }

    public void setRegistquota(Integer registquota) {
        this.registquota = registquota;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}