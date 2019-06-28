package com.example.demo.model;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Date orderDate;

    private Integer userId;

    private String orderSendType;

    private Integer flag;

    private Integer adressId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderSendType() {
        return orderSendType;
    }

    public void setOrderSendType(String orderSendType) {
        this.orderSendType = orderSendType == null ? null : orderSendType.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }
}