package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

//药品
public class Drugs {
    private Integer id;//药品主键ID，即药品编码
    private String drugsName;//药品名称
    private String drugsFormat;//药品规格
    private String drugsUnit;//包装单位
    private String manufacturer;//药品生产厂家
    private String drugsDosage;//药品剂型
    private String drugsType;//药品类型
    private BigDecimal drugsPrice;//药品价格
    private String mnemonicCode;//拼音助记码
    private Date creationDate;//创建日期
    private Date lastUpdateDate;//最后修改日期









    @JsonIgnore
    private Integer delmark;

    @JsonIgnore
    /**
     * @deprecated
     */
    private String drugsCode;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @deprecated
     */
    public String getDrugsCode() {
        return drugsCode;
    }
    /**
     * @deprecated
     */
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