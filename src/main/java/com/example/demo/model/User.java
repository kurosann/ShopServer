package com.example.demo.model;

import java.util.List;

public class User {
    private Integer userId;

    private String userName;

    private String userNike;

    private String userPassword;

    private String userEmail;

    private String userPhone;

    private Float userMoney;

    private String userHeadIcon;

    private Integer userDefaultAddressId;

    private List<FeedBack> feedBacks;


    public List<FeedBack> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(List<FeedBack> feedBacks) {
        this.feedBacks = feedBacks;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNike() {
        return userNike;
    }

    public void setUserNike(String userNike) {
        this.userNike = userNike == null ? null : userNike.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Float getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserHeadIcon() {
        return userHeadIcon;
    }

    public void setUserHeadIcon(String userHeadIcon) {
        this.userHeadIcon = userHeadIcon == null ? null : userHeadIcon.trim();
    }

    public Integer getUserDefaultAddressId() {
        return userDefaultAddressId;
    }

    public void setUserDefaultAddressId(Integer userDefaultAddressId) {
        this.userDefaultAddressId = userDefaultAddressId;
    }
}