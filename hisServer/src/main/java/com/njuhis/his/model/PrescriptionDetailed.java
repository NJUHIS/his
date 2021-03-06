package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//处方明细
public class PrescriptionDetailed {
    private Integer id;//处方明细主键ID
    private Integer prescriptionid;//处方主键ID
    private Integer drugsid;//药品主键ID
    private String useage;//用法
    private String dosage;//用量
    private String frequency;//频次
    private BigDecimal price;//开立处方时药品的单价。
    // 主要是为了防止药品价格变动，所以留下记录。
    private Integer quantity;//数量



    private Drugs drugs;//一对一对应药品


    public void setDrugs(Drugs drugs) {
        this.drugs = drugs;
    }

    public Drugs getDrugs() {
        return drugs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Integer getDrugsid() {
        return drugsid;
    }

    public void setDrugsid(Integer drugsid) {
        this.drugsid = drugsid;
    }

    public String getUseage() {
        return useage;
    }

    public void setUseage(String useage) {
        this.useage = useage == null ? null : useage.trim();
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage == null ? null : dosage.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //不能為空的字段
    @JsonIgnore
    private static final String[][] notEmptyFieldsCheckListString =new String[][]{
            //字段名+英文名+中文翻譯
            {"prescriptionid","Prescription ID","病历主键ID"},
            {"drugsid","Drug ID","药品主键ID"},
            {"quantity","Quantity","数量"}

    };
    @JsonIgnore
    private static final Map<String, String[]> notEmptyFieldsCheckList =new HashMap<>();
    public PrescriptionDetailed(){
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