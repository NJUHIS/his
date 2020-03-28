package com.njuhis.his.model;

import java.math.BigDecimal;

public class CheckDetailed {
    private Integer id;

    private Integer checkappid;

    private Integer checkprojid;

    private Integer deptid;

    private Integer creationtime;

    private String position;

    private Integer state;

    private BigDecimal price;

    private Integer identification;

    private Integer inspecttime;

    private String result;

    private Integer resulttime;

    private Integer operatorid;

    private Integer entryclerkid;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckappid() {
        return checkappid;
    }

    public void setCheckappid(Integer checkappid) {
        this.checkappid = checkappid;
    }

    public Integer getCheckprojid() {
        return checkprojid;
    }

    public void setCheckprojid(Integer checkprojid) {
        this.checkprojid = checkprojid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Integer creationtime) {
        this.creationtime = creationtime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getIdentification() {
        return identification;
    }

    public void setIdentification(Integer identification) {
        this.identification = identification;
    }

    public Integer getInspecttime() {
        return inspecttime;
    }

    public void setInspecttime(Integer inspecttime) {
        this.inspecttime = inspecttime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getResulttime() {
        return resulttime;
    }

    public void setResulttime(Integer resulttime) {
        this.resulttime = resulttime;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public Integer getEntryclerkid() {
        return entryclerkid;
    }

    public void setEntryclerkid(Integer entryclerkid) {
        this.entryclerkid = entryclerkid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}