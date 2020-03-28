package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
//检验检查处置明细
public class CheckDetailed {
    private Integer id; //检验检查处置明细主键ID
    private Integer checkappid; //检验检查处置申请主键ID
    private Integer checkprojid;//检验检查处置项目（属于非药品收费项目）主键ID
    private Integer deptid;//执行科室主键ID
    private String position;//检验检查处置目的和要求
    private Integer state;//检验检查处置状态
    // 1 - 等待检验检查处置
    // 2 - 检验检查处置中
    // 3 - 检验检查处置完成，结果未出
    // 4 - 结果已出
    private BigDecimal price; //单价
    private Integer identification;//标识
    // 1 - 检查项
    // 2 - 检验项
    // 3 - 处置项
    private Integer inspecttime;//实际检查时间
    private String result;//检验检查处置结果
    private Integer resulttime;//出检验检查处置结果的时间
    private Integer userid2;//结果录入人员用户主键ID
    private Integer userid;//检验检查处置人员用户主键ID


    @JsonIgnore
    private Integer delmark;

    /**
     * @deprecated
     */
    @JsonIgnore
    private Integer creationtime;

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

    /**
     * @deprecated
     */
    public Integer getCreationtime() {
        return creationtime;
    }

    /**
     * @deprecated
     */
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