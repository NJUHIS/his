package com.njuhis.his.model;

import java.math.BigDecimal;

public class PrescriptionDetailed {
    private Integer id;//处方明细表主键ID
    private Integer prescriptionid;//处方主键ID
    private Integer drugsid;//药品主键ID
    private String useage;//用法
    private String dosage;//用量
    private String frequency;//频次
    private BigDecimal price;//开立处方时药品的单价。
    // 主要是为了防止药品价格变动，所以留下记录。

    //TODO 需要添加一个药品数量。

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
}