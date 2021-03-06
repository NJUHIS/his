package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//处方
public class Prescription {
    private Integer id;//处方主键ID
    private Integer medicalId;//病历主键ID
    private Integer userId;//开立医生的医院员工主键ID
    private String prescriptionName;//处方名称
    private Integer prescriptionState;//处方状态
    //1 - 编辑中
    //2 - 已确认并发出，未收费。
    //3 - 已收费，未取药。
    //4 - 已取药。
    private Long prescriptionTime;//生效时间。以医生确认发出的时间为准。毫秒数。
    private String invoiceId;//发票主键ID



    private List<PrescriptionDetailed> prescriptionDetailedList;//一对多 包含明细



    @JsonIgnore
    private Integer delmark;



    public List<PrescriptionDetailed> getPrescriptionDetailedList() {
        return prescriptionDetailedList;
    }

    public void setPrescriptionDetailedList(List<PrescriptionDetailed> prescriptionDetailedList) {
        this.prescriptionDetailedList = prescriptionDetailedList;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(Integer medicalId) {
        this.medicalId = medicalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName == null ? null : prescriptionName.trim();
    }

    public Integer getPrescriptionState() {
        return prescriptionState;
    }

    public void setPrescriptionState(Integer prescriptionState) {
        this.prescriptionState = prescriptionState;
    }

    public Long getPrescriptionTime() {
        return prescriptionTime;
    }

    public void setPrescriptionTime(Long prescriptionTime) {
        this.prescriptionTime = prescriptionTime;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
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
    public Prescription(){
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