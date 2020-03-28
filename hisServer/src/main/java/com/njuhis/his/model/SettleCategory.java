package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


//结算类型
public class SettleCategory {
    private Integer id;//结算类型主键ID
    private String settlename;//结算类型名称
    //如包括自费、医保、新农合等。












    
    @JsonIgnore
    /**
     * @deprecated
     */
    private Integer isdefault;
    @JsonIgnore
    /**
     * @deprecated
     */
    private Integer sequence;
    @JsonIgnore
    private Integer delmark;

    /**
     * @deprecated
     */
    @JsonIgnore
    private String settlecode;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @deprecated
     */
    public String getSettlecode() {
        return settlecode;
    }

    /**
     * @deprecated
     */
    public void setSettlecode(String settlecode) {
        this.settlecode = settlecode == null ? null : settlecode.trim();
    }

    public String getSettlename() {
        return settlename;
    }

    public void setSettlename(String settlename) {
        this.settlename = settlename == null ? null : settlename.trim();
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

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}