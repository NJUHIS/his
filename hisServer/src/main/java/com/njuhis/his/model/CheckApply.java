package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

//检验检查处置申请表
public class CheckApply {
    private Integer id;//检验检查处置申请表主键ID
    private Integer medicalId;//病历主键ID
    private Integer creationTime; //开立时间。毫秒数。以开立发出时为准。
    private BigDecimal totalSum; //总金额。自动根据检验检查处置明细表计算。
    private String objective; //目的要求
    private Integer userId;//开立医生用户主键ID
    private Integer state;//检验检查处置申请表状态
    //1 - 编辑中
    //2 - 已开立并发出，未收费
    //3 - 已收费，未检验检查处置
    //4 - 正在检验检查处置或等待结果
    //5 - 检验检查处置已完成，结果已出
    //TODO 最好把发票编号改为发票主键ID







    @JsonIgnore
    /**
     * @deprecated
     */
    private String invoiceNumber;//发票编号。
    @JsonIgnore
    private Integer delmark;

    /**
     * @deprecated
     */
    @JsonIgnore
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @deprecated
     */
    public String getName() {
        return name;
    }

    /**
     * @deprecated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(Integer medicalId) {
        this.medicalId = medicalId;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective == null ? null : objective.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}