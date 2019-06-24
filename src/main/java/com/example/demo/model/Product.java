package com.example.demo.model;

import java.util.Date;

public class Product {
    private Integer productId;

    private Integer productTypeId;

    private String productName;

    private Float oldProductPrice;

    private Float newProductPrice;

    private String productSpec;

    private String productSize;

    private Integer productFlag;

    private String productBroad;

    private Integer productStock;

    private String productPic;

    private Date productRemainTime;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Float getOldProductPrice() {
        return oldProductPrice;
    }

    public void setOldProductPrice(Float oldProductPrice) {
        this.oldProductPrice = oldProductPrice;
    }

    public Float getNewProductPrice() {
        return newProductPrice;
    }

    public void setNewProductPrice(Float newProductPrice) {
        this.newProductPrice = newProductPrice;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec == null ? null : productSpec.trim();
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize == null ? null : productSize.trim();
    }

    public Integer getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(Integer productFlag) {
        this.productFlag = productFlag;
    }

    public String getProductBroad() {
        return productBroad;
    }

    public void setProductBroad(String productBroad) {
        this.productBroad = productBroad == null ? null : productBroad.trim();
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic == null ? null : productPic.trim();
    }

    public Date getProductRemainTime() {
        return productRemainTime;
    }

    public void setProductRemainTime(Date productRemainTime) {
        this.productRemainTime = productRemainTime;
    }
}