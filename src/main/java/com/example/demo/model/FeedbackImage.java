package com.example.demo.model;

public class FeedbackImage {
    private Integer feedbackImageId;

    private Integer feedbackId;

    private String feedbackImage;

    public Integer getFeedbackImageId() {
        return feedbackImageId;
    }

    public void setFeedbackImageId(Integer feedbackImageId) {
        this.feedbackImageId = feedbackImageId;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackImage() {
        return feedbackImage;
    }

    public void setFeedbackImage(String feedbackImage) {
        this.feedbackImage = feedbackImage;
    }
}