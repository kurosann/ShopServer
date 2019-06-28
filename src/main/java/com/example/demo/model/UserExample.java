package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNikeIsNull() {
            addCriterion("user_nike is null");
            return (Criteria) this;
        }

        public Criteria andUserNikeIsNotNull() {
            addCriterion("user_nike is not null");
            return (Criteria) this;
        }

        public Criteria andUserNikeEqualTo(String value) {
            addCriterion("user_nike =", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeNotEqualTo(String value) {
            addCriterion("user_nike <>", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeGreaterThan(String value) {
            addCriterion("user_nike >", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeGreaterThanOrEqualTo(String value) {
            addCriterion("user_nike >=", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeLessThan(String value) {
            addCriterion("user_nike <", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeLessThanOrEqualTo(String value) {
            addCriterion("user_nike <=", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeLike(String value) {
            addCriterion("user_nike like", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeNotLike(String value) {
            addCriterion("user_nike not like", value, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeIn(List<String> values) {
            addCriterion("user_nike in", values, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeNotIn(List<String> values) {
            addCriterion("user_nike not in", values, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeBetween(String value1, String value2) {
            addCriterion("user_nike between", value1, value2, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserNikeNotBetween(String value1, String value2) {
            addCriterion("user_nike not between", value1, value2, "userNike");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIsNull() {
            addCriterion("user_money is null");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIsNotNull() {
            addCriterion("user_money is not null");
            return (Criteria) this;
        }

        public Criteria andUserMoneyEqualTo(Float value) {
            addCriterion("user_money =", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotEqualTo(Float value) {
            addCriterion("user_money <>", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyGreaterThan(Float value) {
            addCriterion("user_money >", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("user_money >=", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyLessThan(Float value) {
            addCriterion("user_money <", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyLessThanOrEqualTo(Float value) {
            addCriterion("user_money <=", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIn(List<Float> values) {
            addCriterion("user_money in", values, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotIn(List<Float> values) {
            addCriterion("user_money not in", values, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyBetween(Float value1, Float value2) {
            addCriterion("user_money between", value1, value2, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotBetween(Float value1, Float value2) {
            addCriterion("user_money not between", value1, value2, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconIsNull() {
            addCriterion("user_head_icon is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconIsNotNull() {
            addCriterion("user_head_icon is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconEqualTo(String value) {
            addCriterion("user_head_icon =", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconNotEqualTo(String value) {
            addCriterion("user_head_icon <>", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconGreaterThan(String value) {
            addCriterion("user_head_icon >", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconGreaterThanOrEqualTo(String value) {
            addCriterion("user_head_icon >=", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconLessThan(String value) {
            addCriterion("user_head_icon <", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconLessThanOrEqualTo(String value) {
            addCriterion("user_head_icon <=", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconLike(String value) {
            addCriterion("user_head_icon like", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconNotLike(String value) {
            addCriterion("user_head_icon not like", value, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconIn(List<String> values) {
            addCriterion("user_head_icon in", values, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconNotIn(List<String> values) {
            addCriterion("user_head_icon not in", values, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconBetween(String value1, String value2) {
            addCriterion("user_head_icon between", value1, value2, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserHeadIconNotBetween(String value1, String value2) {
            addCriterion("user_head_icon not between", value1, value2, "userHeadIcon");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdIsNull() {
            addCriterion("user_default_address_id is null");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdIsNotNull() {
            addCriterion("user_default_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdEqualTo(Integer value) {
            addCriterion("user_default_address_id =", value, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdNotEqualTo(Integer value) {
            addCriterion("user_default_address_id <>", value, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdGreaterThan(Integer value) {
            addCriterion("user_default_address_id >", value, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_default_address_id >=", value, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdLessThan(Integer value) {
            addCriterion("user_default_address_id <", value, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_default_address_id <=", value, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdIn(List<Integer> values) {
            addCriterion("user_default_address_id in", values, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdNotIn(List<Integer> values) {
            addCriterion("user_default_address_id not in", values, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("user_default_address_id between", value1, value2, "userDefaultAddressId");
            return (Criteria) this;
        }

        public Criteria andUserDefaultAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_default_address_id not between", value1, value2, "userDefaultAddressId");
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