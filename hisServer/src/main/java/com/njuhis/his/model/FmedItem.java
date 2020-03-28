package com.njuhis.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
//非药品收费项目
public class FmedItem {
    private Integer id;//非药品收费项目主键ID
    private String itemname; //非药品收费项目名稱
    private String format;//规格
    private BigDecimal price;//单价
    private Integer expclassid;//费用科目主键ID
    private Integer deptid;//执行科室主键ID
    private String itemcode;//非药品收费项目编码

    @JsonIgnore
    private Integer delmark;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getExpclassid() {
        return expclassid;
    }

    public void setExpclassid(Integer expclassid) {
        this.expclassid = expclassid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}