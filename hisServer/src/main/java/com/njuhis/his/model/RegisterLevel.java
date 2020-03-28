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
    /**
     * @deprecated
     */
    @JsonIgnore
    private Integer registquota;//挂号级别限额
    /**
     * @deprecated
     */
    @JsonIgnore
    private Integer isdefault;
    /**
     * @deprecated
     */
    @JsonIgnore
    private Integer sequence;
    /**
     * @deprecated
     */
    @JsonIgnore
    private String registcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @deprecated
     */
    public String getRegistcode() {
        return registcode;
    }

    /**
     * @deprecated
     */
    public void setRegistcode(String registcode) {
        this.registcode = registcode == null ? null : registcode.trim();
    }

    public String getRegistname() {
        return registname;
    }

    public void setRegistname(String registname) {
        this.registname = registname == null ? null : registname.trim();
    }
    /**
     * @deprecated
     */
    public Integer getIsdefault() {
        return isdefault;
    }
    /**
     * @deprecated
     */
    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }
    /**
     * @deprecated
     */
    public Integer getSequence() {
        return sequence;
    }
    /**
     * @deprecated
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getRegistfee() {
        return registfee;
    }

    public void setRegistfee(BigDecimal registfee) {
        this.registfee = registfee;
    }
    /**
     * @deprecated
     */
    public Integer getRegistquota() {
        return registquota;
    }
    /**
     * @deprecated
     */
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