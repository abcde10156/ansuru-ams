package com.ansuru.ams.svr.user.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAssetCodeIsNull() {
            addCriterion("asset_code is null");
            return (Criteria) this;
        }

        public Criteria andAssetCodeIsNotNull() {
            addCriterion("asset_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssetCodeEqualTo(String value) {
            addCriterion("asset_code =", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotEqualTo(String value) {
            addCriterion("asset_code <>", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeGreaterThan(String value) {
            addCriterion("asset_code >", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_code >=", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeLessThan(String value) {
            addCriterion("asset_code <", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeLessThanOrEqualTo(String value) {
            addCriterion("asset_code <=", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeLike(String value) {
            addCriterion("asset_code like", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotLike(String value) {
            addCriterion("asset_code not like", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeIn(List<String> values) {
            addCriterion("asset_code in", values, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotIn(List<String> values) {
            addCriterion("asset_code not in", values, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeBetween(String value1, String value2) {
            addCriterion("asset_code between", value1, value2, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotBetween(String value1, String value2) {
            addCriterion("asset_code not between", value1, value2, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetNameIsNull() {
            addCriterion("asset_name is null");
            return (Criteria) this;
        }

        public Criteria andAssetNameIsNotNull() {
            addCriterion("asset_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssetNameEqualTo(String value) {
            addCriterion("asset_name =", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotEqualTo(String value) {
            addCriterion("asset_name <>", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameGreaterThan(String value) {
            addCriterion("asset_name >", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameGreaterThanOrEqualTo(String value) {
            addCriterion("asset_name >=", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameLessThan(String value) {
            addCriterion("asset_name <", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameLessThanOrEqualTo(String value) {
            addCriterion("asset_name <=", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameLike(String value) {
            addCriterion("asset_name like", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotLike(String value) {
            addCriterion("asset_name not like", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameIn(List<String> values) {
            addCriterion("asset_name in", values, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotIn(List<String> values) {
            addCriterion("asset_name not in", values, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameBetween(String value1, String value2) {
            addCriterion("asset_name between", value1, value2, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotBetween(String value1, String value2) {
            addCriterion("asset_name not between", value1, value2, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetCateIsNull() {
            addCriterion("asset_cate is null");
            return (Criteria) this;
        }

        public Criteria andAssetCateIsNotNull() {
            addCriterion("asset_cate is not null");
            return (Criteria) this;
        }

        public Criteria andAssetCateEqualTo(Short value) {
            addCriterion("asset_cate =", value, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateNotEqualTo(Short value) {
            addCriterion("asset_cate <>", value, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateGreaterThan(Short value) {
            addCriterion("asset_cate >", value, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateGreaterThanOrEqualTo(Short value) {
            addCriterion("asset_cate >=", value, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateLessThan(Short value) {
            addCriterion("asset_cate <", value, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateLessThanOrEqualTo(Short value) {
            addCriterion("asset_cate <=", value, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateIn(List<Short> values) {
            addCriterion("asset_cate in", values, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateNotIn(List<Short> values) {
            addCriterion("asset_cate not in", values, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateBetween(Short value1, Short value2) {
            addCriterion("asset_cate between", value1, value2, "assetCate");
            return (Criteria) this;
        }

        public Criteria andAssetCateNotBetween(Short value1, Short value2) {
            addCriterion("asset_cate not between", value1, value2, "assetCate");
            return (Criteria) this;
        }

        public Criteria andUsedStatusIsNull() {
            addCriterion("used_status is null");
            return (Criteria) this;
        }

        public Criteria andUsedStatusIsNotNull() {
            addCriterion("used_status is not null");
            return (Criteria) this;
        }

        public Criteria andUsedStatusEqualTo(Short value) {
            addCriterion("used_status =", value, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusNotEqualTo(Short value) {
            addCriterion("used_status <>", value, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusGreaterThan(Short value) {
            addCriterion("used_status >", value, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("used_status >=", value, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusLessThan(Short value) {
            addCriterion("used_status <", value, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusLessThanOrEqualTo(Short value) {
            addCriterion("used_status <=", value, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusIn(List<Short> values) {
            addCriterion("used_status in", values, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusNotIn(List<Short> values) {
            addCriterion("used_status not in", values, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusBetween(Short value1, Short value2) {
            addCriterion("used_status between", value1, value2, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andUsedStatusNotBetween(Short value1, Short value2) {
            addCriterion("used_status not between", value1, value2, "usedStatus");
            return (Criteria) this;
        }

        public Criteria andLentUserIsNull() {
            addCriterion("lent_user is null");
            return (Criteria) this;
        }

        public Criteria andLentUserIsNotNull() {
            addCriterion("lent_user is not null");
            return (Criteria) this;
        }

        public Criteria andLentUserEqualTo(String value) {
            addCriterion("lent_user =", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserNotEqualTo(String value) {
            addCriterion("lent_user <>", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserGreaterThan(String value) {
            addCriterion("lent_user >", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserGreaterThanOrEqualTo(String value) {
            addCriterion("lent_user >=", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserLessThan(String value) {
            addCriterion("lent_user <", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserLessThanOrEqualTo(String value) {
            addCriterion("lent_user <=", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserLike(String value) {
            addCriterion("lent_user like", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserNotLike(String value) {
            addCriterion("lent_user not like", value, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserIn(List<String> values) {
            addCriterion("lent_user in", values, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserNotIn(List<String> values) {
            addCriterion("lent_user not in", values, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserBetween(String value1, String value2) {
            addCriterion("lent_user between", value1, value2, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentUserNotBetween(String value1, String value2) {
            addCriterion("lent_user not between", value1, value2, "lentUser");
            return (Criteria) this;
        }

        public Criteria andLentStartDtIsNull() {
            addCriterion("lent_start_dt is null");
            return (Criteria) this;
        }

        public Criteria andLentStartDtIsNotNull() {
            addCriterion("lent_start_dt is not null");
            return (Criteria) this;
        }

        public Criteria andLentStartDtEqualTo(Date value) {
            addCriterion("lent_start_dt =", value, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtNotEqualTo(Date value) {
            addCriterion("lent_start_dt <>", value, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtGreaterThan(Date value) {
            addCriterion("lent_start_dt >", value, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtGreaterThanOrEqualTo(Date value) {
            addCriterion("lent_start_dt >=", value, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtLessThan(Date value) {
            addCriterion("lent_start_dt <", value, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtLessThanOrEqualTo(Date value) {
            addCriterion("lent_start_dt <=", value, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtIn(List<Date> values) {
            addCriterion("lent_start_dt in", values, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtNotIn(List<Date> values) {
            addCriterion("lent_start_dt not in", values, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtBetween(Date value1, Date value2) {
            addCriterion("lent_start_dt between", value1, value2, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentStartDtNotBetween(Date value1, Date value2) {
            addCriterion("lent_start_dt not between", value1, value2, "lentStartDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtIsNull() {
            addCriterion("lent_end_dt is null");
            return (Criteria) this;
        }

        public Criteria andLentEndDtIsNotNull() {
            addCriterion("lent_end_dt is not null");
            return (Criteria) this;
        }

        public Criteria andLentEndDtEqualTo(Date value) {
            addCriterion("lent_end_dt =", value, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtNotEqualTo(Date value) {
            addCriterion("lent_end_dt <>", value, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtGreaterThan(Date value) {
            addCriterion("lent_end_dt >", value, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtGreaterThanOrEqualTo(Date value) {
            addCriterion("lent_end_dt >=", value, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtLessThan(Date value) {
            addCriterion("lent_end_dt <", value, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtLessThanOrEqualTo(Date value) {
            addCriterion("lent_end_dt <=", value, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtIn(List<Date> values) {
            addCriterion("lent_end_dt in", values, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtNotIn(List<Date> values) {
            addCriterion("lent_end_dt not in", values, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtBetween(Date value1, Date value2) {
            addCriterion("lent_end_dt between", value1, value2, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andLentEndDtNotBetween(Date value1, Date value2) {
            addCriterion("lent_end_dt not between", value1, value2, "lentEndDt");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("created_dt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("created_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterion("created_dt =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterion("created_dt <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterion("created_dt >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_dt >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterion("created_dt <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterion("created_dt <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterion("created_dt in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterion("created_dt not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterion("created_dt between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterion("created_dt not between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedNameIsNull() {
            addCriterion("created_name is null");
            return (Criteria) this;
        }

        public Criteria andCreatedNameIsNotNull() {
            addCriterion("created_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedNameEqualTo(String value) {
            addCriterion("created_name =", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameNotEqualTo(String value) {
            addCriterion("created_name <>", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameGreaterThan(String value) {
            addCriterion("created_name >", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameGreaterThanOrEqualTo(String value) {
            addCriterion("created_name >=", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameLessThan(String value) {
            addCriterion("created_name <", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameLessThanOrEqualTo(String value) {
            addCriterion("created_name <=", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameLike(String value) {
            addCriterion("created_name like", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameNotLike(String value) {
            addCriterion("created_name not like", value, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameIn(List<String> values) {
            addCriterion("created_name in", values, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameNotIn(List<String> values) {
            addCriterion("created_name not in", values, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameBetween(String value1, String value2) {
            addCriterion("created_name between", value1, value2, "createdName");
            return (Criteria) this;
        }

        public Criteria andCreatedNameNotBetween(String value1, String value2) {
            addCriterion("created_name not between", value1, value2, "createdName");
            return (Criteria) this;
        }

        public Criteria andModifiedDtIsNull() {
            addCriterion("modified_dt is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDtIsNotNull() {
            addCriterion("modified_dt is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDtEqualTo(Date value) {
            addCriterion("modified_dt =", value, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtNotEqualTo(Date value) {
            addCriterion("modified_dt <>", value, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtGreaterThan(Date value) {
            addCriterion("modified_dt >", value, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_dt >=", value, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtLessThan(Date value) {
            addCriterion("modified_dt <", value, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtLessThanOrEqualTo(Date value) {
            addCriterion("modified_dt <=", value, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtIn(List<Date> values) {
            addCriterion("modified_dt in", values, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtNotIn(List<Date> values) {
            addCriterion("modified_dt not in", values, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtBetween(Date value1, Date value2) {
            addCriterion("modified_dt between", value1, value2, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedDtNotBetween(Date value1, Date value2) {
            addCriterion("modified_dt not between", value1, value2, "modifiedDt");
            return (Criteria) this;
        }

        public Criteria andModifiedNameIsNull() {
            addCriterion("modified_name is null");
            return (Criteria) this;
        }

        public Criteria andModifiedNameIsNotNull() {
            addCriterion("modified_name is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedNameEqualTo(String value) {
            addCriterion("modified_name =", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotEqualTo(String value) {
            addCriterion("modified_name <>", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameGreaterThan(String value) {
            addCriterion("modified_name >", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameGreaterThanOrEqualTo(String value) {
            addCriterion("modified_name >=", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLessThan(String value) {
            addCriterion("modified_name <", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLessThanOrEqualTo(String value) {
            addCriterion("modified_name <=", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLike(String value) {
            addCriterion("modified_name like", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotLike(String value) {
            addCriterion("modified_name not like", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameIn(List<String> values) {
            addCriterion("modified_name in", values, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotIn(List<String> values) {
            addCriterion("modified_name not in", values, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameBetween(String value1, String value2) {
            addCriterion("modified_name between", value1, value2, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotBetween(String value1, String value2) {
            addCriterion("modified_name not between", value1, value2, "modifiedName");
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