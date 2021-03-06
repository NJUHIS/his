package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//检验检查处置
//这个类是个巨无霸，耦合了非常多的业务。包括检查Examination、检验Test和处置Disposal
public class CheckApply {
    private Integer id;//检验检查处置主键ID
    private Integer medicalId;//病历主键ID
    private Long creationTime; //生效时间。以医生确认发出的时间为准。毫秒数。
    private BigDecimal totalSum; //总金额。自动根据检验检查处置明细计算。
    private String objective; //目的和要求
    private Integer userId;//开立医生的医院员工主键ID
    private Integer state;//检验检查处置状态
    //1 - 编辑中
    //2 - 已开立并发出，未收费
    //3 - 已收费，未检验检查处置
    //4 - 正在检验检查处置或等待结果
    //5 - 检验检查处置已完成，结果已出
    private Integer invoiceId;//发票主键ID
    private List<CheckDetailed> checkDetailedList ;
    private Register register;

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    @JsonIgnore
    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setCheckDetailedList(List<CheckDetailed> checkDetailedList) {
        this.checkDetailedList = checkDetailedList;
    }

    public List<CheckDetailed> getCheckDetailedList() {
        return checkDetailedList;
    }


    public Integer getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(Integer medicalId) {
        this.medicalId = medicalId;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
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

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }

    //不能為空的字段
    @JsonIgnore
    private static final String[][] notEmptyFieldsCheckListString =new String[][]{
            //字段名+英文名+中文翻譯
            {"medicalId","Medical Record ID","病历主键ID"}

    };
    @JsonIgnore
    private static final Map<String, String[]> notEmptyFieldsCheckList =new HashMap<>();
    public CheckApply(){
        for(String[]fieldToCheckNotEmpty: notEmptyFieldsCheckListString){
            String[] fieldTranslations=new String[]{
                    fieldToCheckNotEmpty[1],fieldToCheckNotEmpty[2]
            };
            notEmptyFieldsCheckList.put(fieldToCheckNotEmpty[0],fieldTranslations);
        }
    }

    public static Map<String, String[]> getNotEmptyFieldsCheckList() {
        return notEmptyFieldsCheckList;
    }
}