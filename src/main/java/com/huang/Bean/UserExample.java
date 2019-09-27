package com.huang.Bean;

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

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Integer value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Integer value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Integer value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Integer> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTUsernameIsNull() {
            addCriterion("t_username is null");
            return (Criteria) this;
        }

        public Criteria andTUsernameIsNotNull() {
            addCriterion("t_username is not null");
            return (Criteria) this;
        }

        public Criteria andTUsernameEqualTo(String value) {
            addCriterion("t_username =", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotEqualTo(String value) {
            addCriterion("t_username <>", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameGreaterThan(String value) {
            addCriterion("t_username >", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("t_username >=", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameLessThan(String value) {
            addCriterion("t_username <", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameLessThanOrEqualTo(String value) {
            addCriterion("t_username <=", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameLike(String value) {
            addCriterion("t_username like", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotLike(String value) {
            addCriterion("t_username not like", value, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameIn(List<String> values) {
            addCriterion("t_username in", values, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotIn(List<String> values) {
            addCriterion("t_username not in", values, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameBetween(String value1, String value2) {
            addCriterion("t_username between", value1, value2, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTUsernameNotBetween(String value1, String value2) {
            addCriterion("t_username not between", value1, value2, "tUsername");
            return (Criteria) this;
        }

        public Criteria andTAccountIsNull() {
            addCriterion("t_account is null");
            return (Criteria) this;
        }

        public Criteria andTAccountIsNotNull() {
            addCriterion("t_account is not null");
            return (Criteria) this;
        }

        public Criteria andTAccountEqualTo(String value) {
            addCriterion("t_account =", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountNotEqualTo(String value) {
            addCriterion("t_account <>", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountGreaterThan(String value) {
            addCriterion("t_account >", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountGreaterThanOrEqualTo(String value) {
            addCriterion("t_account >=", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountLessThan(String value) {
            addCriterion("t_account <", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountLessThanOrEqualTo(String value) {
            addCriterion("t_account <=", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountLike(String value) {
            addCriterion("t_account like", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountNotLike(String value) {
            addCriterion("t_account not like", value, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountIn(List<String> values) {
            addCriterion("t_account in", values, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountNotIn(List<String> values) {
            addCriterion("t_account not in", values, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountBetween(String value1, String value2) {
            addCriterion("t_account between", value1, value2, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTAccountNotBetween(String value1, String value2) {
            addCriterion("t_account not between", value1, value2, "tAccount");
            return (Criteria) this;
        }

        public Criteria andTPasswordIsNull() {
            addCriterion("t_password is null");
            return (Criteria) this;
        }

        public Criteria andTPasswordIsNotNull() {
            addCriterion("t_password is not null");
            return (Criteria) this;
        }

        public Criteria andTPasswordEqualTo(String value) {
            addCriterion("t_password =", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotEqualTo(String value) {
            addCriterion("t_password <>", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordGreaterThan(String value) {
            addCriterion("t_password >", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("t_password >=", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordLessThan(String value) {
            addCriterion("t_password <", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordLessThanOrEqualTo(String value) {
            addCriterion("t_password <=", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordLike(String value) {
            addCriterion("t_password like", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotLike(String value) {
            addCriterion("t_password not like", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordIn(List<String> values) {
            addCriterion("t_password in", values, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotIn(List<String> values) {
            addCriterion("t_password not in", values, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordBetween(String value1, String value2) {
            addCriterion("t_password between", value1, value2, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotBetween(String value1, String value2) {
            addCriterion("t_password not between", value1, value2, "tPassword");
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