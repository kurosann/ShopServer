package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNull() {
            addCriterion("product_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNotNull() {
            addCriterion("product_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdEqualTo(Integer value) {
            addCriterion("product_type_id =", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotEqualTo(Integer value) {
            addCriterion("product_type_id <>", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThan(Integer value) {
            addCriterion("product_type_id >", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type_id >=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThan(Integer value) {
            addCriterion("product_type_id <", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_type_id <=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIn(List<Integer> values) {
            addCriterion("product_type_id in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotIn(List<Integer> values) {
            addCriterion("product_type_id not in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id not between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceIsNull() {
            addCriterion("old_product_price is null");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceIsNotNull() {
            addCriterion("old_product_price is not null");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceEqualTo(Float value) {
            addCriterion("old_product_price =", value, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceNotEqualTo(Float value) {
            addCriterion("old_product_price <>", value, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceGreaterThan(Float value) {
            addCriterion("old_product_price >", value, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("old_product_price >=", value, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceLessThan(Float value) {
            addCriterion("old_product_price <", value, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceLessThanOrEqualTo(Float value) {
            addCriterion("old_product_price <=", value, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceIn(List<Float> values) {
            addCriterion("old_product_price in", values, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceNotIn(List<Float> values) {
            addCriterion("old_product_price not in", values, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceBetween(Float value1, Float value2) {
            addCriterion("old_product_price between", value1, value2, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andOldProductPriceNotBetween(Float value1, Float value2) {
            addCriterion("old_product_price not between", value1, value2, "oldProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceIsNull() {
            addCriterion("new_product_price is null");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceIsNotNull() {
            addCriterion("new_product_price is not null");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceEqualTo(Float value) {
            addCriterion("new_product_price =", value, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceNotEqualTo(Float value) {
            addCriterion("new_product_price <>", value, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceGreaterThan(Float value) {
            addCriterion("new_product_price >", value, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("new_product_price >=", value, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceLessThan(Float value) {
            addCriterion("new_product_price <", value, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceLessThanOrEqualTo(Float value) {
            addCriterion("new_product_price <=", value, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceIn(List<Float> values) {
            addCriterion("new_product_price in", values, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceNotIn(List<Float> values) {
            addCriterion("new_product_price not in", values, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceBetween(Float value1, Float value2) {
            addCriterion("new_product_price between", value1, value2, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andNewProductPriceNotBetween(Float value1, Float value2) {
            addCriterion("new_product_price not between", value1, value2, "newProductPrice");
            return (Criteria) this;
        }

        public Criteria andProductSpecIsNull() {
            addCriterion("product_spec is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecIsNotNull() {
            addCriterion("product_spec is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecEqualTo(String value) {
            addCriterion("product_spec =", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotEqualTo(String value) {
            addCriterion("product_spec <>", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecGreaterThan(String value) {
            addCriterion("product_spec >", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecGreaterThanOrEqualTo(String value) {
            addCriterion("product_spec >=", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLessThan(String value) {
            addCriterion("product_spec <", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLessThanOrEqualTo(String value) {
            addCriterion("product_spec <=", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLike(String value) {
            addCriterion("product_spec like", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotLike(String value) {
            addCriterion("product_spec not like", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecIn(List<String> values) {
            addCriterion("product_spec in", values, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotIn(List<String> values) {
            addCriterion("product_spec not in", values, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecBetween(String value1, String value2) {
            addCriterion("product_spec between", value1, value2, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotBetween(String value1, String value2) {
            addCriterion("product_spec not between", value1, value2, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSizeIsNull() {
            addCriterion("product_size is null");
            return (Criteria) this;
        }

        public Criteria andProductSizeIsNotNull() {
            addCriterion("product_size is not null");
            return (Criteria) this;
        }

        public Criteria andProductSizeEqualTo(String value) {
            addCriterion("product_size =", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeNotEqualTo(String value) {
            addCriterion("product_size <>", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeGreaterThan(String value) {
            addCriterion("product_size >", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeGreaterThanOrEqualTo(String value) {
            addCriterion("product_size >=", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeLessThan(String value) {
            addCriterion("product_size <", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeLessThanOrEqualTo(String value) {
            addCriterion("product_size <=", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeLike(String value) {
            addCriterion("product_size like", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeNotLike(String value) {
            addCriterion("product_size not like", value, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeIn(List<String> values) {
            addCriterion("product_size in", values, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeNotIn(List<String> values) {
            addCriterion("product_size not in", values, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeBetween(String value1, String value2) {
            addCriterion("product_size between", value1, value2, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductSizeNotBetween(String value1, String value2) {
            addCriterion("product_size not between", value1, value2, "productSize");
            return (Criteria) this;
        }

        public Criteria andProductFlagIsNull() {
            addCriterion("product_flag is null");
            return (Criteria) this;
        }

        public Criteria andProductFlagIsNotNull() {
            addCriterion("product_flag is not null");
            return (Criteria) this;
        }

        public Criteria andProductFlagEqualTo(Integer value) {
            addCriterion("product_flag =", value, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagNotEqualTo(Integer value) {
            addCriterion("product_flag <>", value, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagGreaterThan(Integer value) {
            addCriterion("product_flag >", value, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_flag >=", value, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagLessThan(Integer value) {
            addCriterion("product_flag <", value, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagLessThanOrEqualTo(Integer value) {
            addCriterion("product_flag <=", value, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagIn(List<Integer> values) {
            addCriterion("product_flag in", values, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagNotIn(List<Integer> values) {
            addCriterion("product_flag not in", values, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagBetween(Integer value1, Integer value2) {
            addCriterion("product_flag between", value1, value2, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("product_flag not between", value1, value2, "productFlag");
            return (Criteria) this;
        }

        public Criteria andProductBroadIsNull() {
            addCriterion("product_broad is null");
            return (Criteria) this;
        }

        public Criteria andProductBroadIsNotNull() {
            addCriterion("product_broad is not null");
            return (Criteria) this;
        }

        public Criteria andProductBroadEqualTo(String value) {
            addCriterion("product_broad =", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadNotEqualTo(String value) {
            addCriterion("product_broad <>", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadGreaterThan(String value) {
            addCriterion("product_broad >", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadGreaterThanOrEqualTo(String value) {
            addCriterion("product_broad >=", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadLessThan(String value) {
            addCriterion("product_broad <", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadLessThanOrEqualTo(String value) {
            addCriterion("product_broad <=", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadLike(String value) {
            addCriterion("product_broad like", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadNotLike(String value) {
            addCriterion("product_broad not like", value, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadIn(List<String> values) {
            addCriterion("product_broad in", values, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadNotIn(List<String> values) {
            addCriterion("product_broad not in", values, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadBetween(String value1, String value2) {
            addCriterion("product_broad between", value1, value2, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductBroadNotBetween(String value1, String value2) {
            addCriterion("product_broad not between", value1, value2, "productBroad");
            return (Criteria) this;
        }

        public Criteria andProductStockIsNull() {
            addCriterion("product_stock is null");
            return (Criteria) this;
        }

        public Criteria andProductStockIsNotNull() {
            addCriterion("product_stock is not null");
            return (Criteria) this;
        }

        public Criteria andProductStockEqualTo(Integer value) {
            addCriterion("product_stock =", value, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockNotEqualTo(Integer value) {
            addCriterion("product_stock <>", value, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockGreaterThan(Integer value) {
            addCriterion("product_stock >", value, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_stock >=", value, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockLessThan(Integer value) {
            addCriterion("product_stock <", value, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockLessThanOrEqualTo(Integer value) {
            addCriterion("product_stock <=", value, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockIn(List<Integer> values) {
            addCriterion("product_stock in", values, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockNotIn(List<Integer> values) {
            addCriterion("product_stock not in", values, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockBetween(Integer value1, Integer value2) {
            addCriterion("product_stock between", value1, value2, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductStockNotBetween(Integer value1, Integer value2) {
            addCriterion("product_stock not between", value1, value2, "productStock");
            return (Criteria) this;
        }

        public Criteria andProductPicIsNull() {
            addCriterion("product_pic is null");
            return (Criteria) this;
        }

        public Criteria andProductPicIsNotNull() {
            addCriterion("product_pic is not null");
            return (Criteria) this;
        }

        public Criteria andProductPicEqualTo(String value) {
            addCriterion("product_pic =", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotEqualTo(String value) {
            addCriterion("product_pic <>", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicGreaterThan(String value) {
            addCriterion("product_pic >", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicGreaterThanOrEqualTo(String value) {
            addCriterion("product_pic >=", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLessThan(String value) {
            addCriterion("product_pic <", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLessThanOrEqualTo(String value) {
            addCriterion("product_pic <=", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLike(String value) {
            addCriterion("product_pic like", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotLike(String value) {
            addCriterion("product_pic not like", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicIn(List<String> values) {
            addCriterion("product_pic in", values, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotIn(List<String> values) {
            addCriterion("product_pic not in", values, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicBetween(String value1, String value2) {
            addCriterion("product_pic between", value1, value2, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotBetween(String value1, String value2) {
            addCriterion("product_pic not between", value1, value2, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeIsNull() {
            addCriterion("product_remain_time is null");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeIsNotNull() {
            addCriterion("product_remain_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeEqualTo(Date value) {
            addCriterion("product_remain_time =", value, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeNotEqualTo(Date value) {
            addCriterion("product_remain_time <>", value, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeGreaterThan(Date value) {
            addCriterion("product_remain_time >", value, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_remain_time >=", value, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeLessThan(Date value) {
            addCriterion("product_remain_time <", value, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeLessThanOrEqualTo(Date value) {
            addCriterion("product_remain_time <=", value, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeIn(List<Date> values) {
            addCriterion("product_remain_time in", values, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeNotIn(List<Date> values) {
            addCriterion("product_remain_time not in", values, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeBetween(Date value1, Date value2) {
            addCriterion("product_remain_time between", value1, value2, "productRemainTime");
            return (Criteria) this;
        }

        public Criteria andProductRemainTimeNotBetween(Date value1, Date value2) {
            addCriterion("product_remain_time not between", value1, value2, "productRemainTime");
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