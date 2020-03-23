package com.njuhis.his.model;

import java.math.BigDecimal;
import java.util.Date;

public class CheckDetailed {
    private Integer id;

    private Integer checkappid;

    private Integer checkprojid;

    private Integer deptid;

    private Date creationtime;

    private String position;

    private Integer state;

    private BigDecimal price;

    private Integer identification;

    private Date inspecttime;

    private String result;

    private Date resulttime;

    private Integer userid2;

    private Integer userid;

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

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
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

    public Date getInspecttime() {
        return inspecttime;
    }

    public void setInspecttime(Date inspecttime) {
        this.inspecttime = inspecttime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getResulttime() {
        return resulttime;
    }

    public void setResulttime(Date resulttime) {
        this.resulttime = resulttime;
    }

    public Integer getUserid2() {
        return userid2;
    }

    public void setUserid2(Integer userid2) {
        this.userid2 = userid2;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}