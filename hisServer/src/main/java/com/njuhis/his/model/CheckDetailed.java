package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

//检验检查处置明细
public class CheckDetailed {
    private Integer id; //检验检查处置明细主键ID
    private Integer checkappid; //检验检查处置主键ID
    private Integer checkprojid;//检验检查处置项目（属于非药品项目）主键ID
    private Integer deptid;//执行科室主键ID
    private String position;//检验检查处置明细目的和要求
    private Integer state;//检验检查处置明细状态
    // 1 - 等待检验检查处置
    // 2 - 检验检查处置中
    // 3 - 检验检查处置完成，结果未出
    // 4 - 结果已出
    private BigDecimal price; //价格
    private Integer identification;//检验检查处置明细类型
    // 1 - 检查项
    // 2 - 检验项
    // 3 - 处置项
    private Long inspecttime;//此明细实际检验检查处置时间
    private String result;//此明细的检验检查处置结果
    private Integer resulttime;//此明细出检验检查处置结果的时间。毫秒数。
    private Integer operatorid;//此明细的检验检查处置人员的医院员工主键ID
    private Integer entryclerkid;//此明细的结果录入人员的医院员工主键ID





    @JsonIgnore
    private Integer delmark;
    /**
     * @deprecated
     */
    @JsonIgnore
    private Long creationtime;

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
    public Long getCreationtime() {
        return creationtime;
    }

    /**
     * @deprecated
     */
    public void setCreationtime(Long creationtime) {
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

    public Long getInspecttime() {
        return inspecttime;
    }

    public void setInspecttime(Long inspecttime) {
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