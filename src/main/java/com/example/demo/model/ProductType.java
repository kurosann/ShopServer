package com.example.demo.model;

public class ProductType {
    private Integer productTypeId;

    private String productTypeName;

    private String description;

    private String productTypePic;

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName == null ? null : productTypeName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProductTypePic() {
        return productTypePic;
    }

    public void setProductTypePic(String productTypePic) {
        this.productTypePic = productTypePic == null ? null : productTypePic.trim();
    }
}