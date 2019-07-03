package com.example.demo.model;

import java.util.List;

public class FeedBack {
    public static final String COL_USER_ID = "user_id";
    public static final String COL_PRODUCT_ID = "product_id";
    public static final String COL_FEEDBACK_CONTEXT = "feedback_context";
    private Integer feedbackId;

    private Integer userId;

    private Integer productId;

    private String feedbackContext;

    private List<FeedBackImage> feedBackImages;

    public List<FeedBackImage> getFeedBackImages() {
        return feedBackImages;
    }

    public void setFeedBackImages(List<FeedBackImage> feedBackImages) {
        this.feedBackImages = feedBackImages;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getFeedbackContext() {
        return feedbackContext;
    }

    public void setFeedbackContext(String feedbackContext) {
        this.feedbackContext = feedbackContext;
    }
}