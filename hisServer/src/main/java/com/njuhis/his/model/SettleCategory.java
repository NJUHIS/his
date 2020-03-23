package com.njuhis.his.model;

public class SettleCategory {
    private Integer id;

    private String settlecode;

    private String settlename;

    private Integer isdefault;

    private Integer sequence;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSettlecode() {
        return settlecode;
    }

    public void setSettlecode(String settlecode) {
        this.settlecode = settlecode == null ? null : settlecode.trim();
    }

    public String getSettlename() {
        return settlename;
    }

    public void setSettlename(String settlename) {
        this.settlename = settlename == null ? null : settlename.trim();
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

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}