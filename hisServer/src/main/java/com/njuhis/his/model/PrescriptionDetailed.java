package com.njuhis.his.model;

import java.math.BigDecimal;

public class PrescriptionDetailed {
    private Integer id;

    private Integer prescriptionid;

    private Integer drugsid;

    private String useage;

    private String dosage;

    private String frequency;

    private BigDecimal price;

    private Integer prescriptiondetailedcol;

    private Integer quantity;

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

    public Integer getPrescriptiondetailedcol() {
        return prescriptiondetailedcol;
    }

    public void setPrescriptiondetailedcol(Integer prescriptiondetailedcol) {
        this.prescriptiondetailedcol = prescriptiondetailedcol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}