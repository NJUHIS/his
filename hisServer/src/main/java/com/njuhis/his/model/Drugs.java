package com.njuhis.his.model;

import java.math.BigDecimal;
import java.util.Date;

public class Drugs {
    private Integer id;

    private String drugsCode;

    private String drugsName;

    private String drugsFormat;

    private String drugsUnit;

    private String manufacturer;

    private String drugsDosage;

    private String drugsType;

    private BigDecimal drugsPrice;

    private String mnemonicCode;

    private Date creationDate;

    private Date lastUpdateDate;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugsCode() {
        return drugsCode;
    }

    public void setDrugsCode(String drugsCode) {
        this.drugsCode = drugsCode == null ? null : drugsCode.trim();
    }

    public String getDrugsName() {
        return drugsName;
    }

    public void setDrugsName(String drugsName) {
        this.drugsName = drugsName == null ? null : drugsName.trim();
    }

    public String getDrugsFormat() {
        return drugsFormat;
    }

    public void setDrugsFormat(String drugsFormat) {
        this.drugsFormat = drugsFormat == null ? null : drugsFormat.trim();
    }

    public String getDrugsUnit() {
        return drugsUnit;
    }

    public void setDrugsUnit(String drugsUnit) {
        this.drugsUnit = drugsUnit == null ? null : drugsUnit.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getDrugsDosage() {
        return drugsDosage;
    }

    public void setDrugsDosage(String drugsDosage) {
        this.drugsDosage = drugsDosage == null ? null : drugsDosage.trim();
    }

    public String getDrugsType() {
        return drugsType;
    }

    public void setDrugsType(String drugsType) {
        this.drugsType = drugsType == null ? null : drugsType.trim();
    }

    public BigDecimal getDrugsPrice() {
        return drugsPrice;
    }

    public void setDrugsPrice(BigDecimal drugsPrice) {
        this.drugsPrice = drugsPrice;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode == null ? null : mnemonicCode.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}