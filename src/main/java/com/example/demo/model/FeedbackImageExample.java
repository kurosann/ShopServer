package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class FeedbackImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackImageExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFeedbackImageIdIsNull() {
            addCriterion("feedback_image_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdIsNotNull() {
            addCriterion("feedback_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdEqualTo(Integer value) {
            addCriterion("feedback_image_id =", value, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdNotEqualTo(Integer value) {
            addCriterion("feedback_image_id <>", value, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdGreaterThan(Integer value) {
            addCriterion("feedback_image_id >", value, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_image_id >=", value, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdLessThan(Integer value) {
            addCriterion("feedback_image_id <", value, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_image_id <=", value, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdIn(List<Integer> values) {
            addCriterion("feedback_image_id in", values, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdNotIn(List<Integer> values) {
            addCriterion("feedback_image_id not in", values, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdBetween(Integer value1, Integer value2) {
            addCriterion("feedback_image_id between", value1, value2, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_image_id not between", value1, value2, "feedbackImageId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(Integer value) {
            addCriterion("feedback_id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(Integer value) {
            addCriterion("feedback_id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(Integer value) {
            addCriterion("feedback_id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(Integer value) {
            addCriterion("feedback_id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<Integer> values) {
            addCriterion("feedback_id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<Integer> values) {
            addCriterion("feedback_id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id not between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIsNull() {
            addCriterion("feedback_image is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIsNotNull() {
            addCriterion("feedback_image is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageEqualTo(String value) {
            addCriterion("feedback_image =", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageNotEqualTo(String value) {
            addCriterion("feedback_image <>", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageGreaterThan(String value) {
            addCriterion("feedback_image >", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_image >=", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageLessThan(String value) {
            addCriterion("feedback_image <", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageLessThanOrEqualTo(String value) {
            addCriterion("feedback_image <=", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageLike(String value) {
            addCriterion("feedback_image like", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageNotLike(String value) {
            addCriterion("feedback_image not like", value, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageIn(List<String> values) {
            addCriterion("feedback_image in", values, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageNotIn(List<String> values) {
            addCriterion("feedback_image not in", values, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageBetween(String value1, String value2) {
            addCriterion("feedback_image between", value1, value2, "feedbackImage");
            return (Criteria) this;
        }

        public Criteria andFeedbackImageNotBetween(String value1, String value2) {
            addCriterion("feedback_image not between", value1, value2, "feedbackImage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}