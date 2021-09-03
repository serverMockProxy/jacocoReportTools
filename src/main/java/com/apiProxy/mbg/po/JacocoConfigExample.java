package com.apiProxy.mbg.po;

import java.util.ArrayList;
import java.util.List;

public class JacocoConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JacocoConfigExample() {
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
        protected List<Criterion> childrenCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            childrenCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getChildrenCriteria() {
            return childrenCriteria;
        }

        protected void addChildrenCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            childrenCriteria.add(new Criterion(condition, value, "com.apiProxy.typehandler.JacocoConfigListTypeHandler"));
            allCriteria = null;
        }

        protected void addChildrenCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            childrenCriteria.add(new Criterion(condition, value1, value2, "com.apiProxy.typehandler.JacocoConfigListTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                    || childrenCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(childrenCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andGitIdIsNull() {
            addCriterion("git_id is null");
            return (Criteria) this;
        }

        public Criteria andGitIdIsNotNull() {
            addCriterion("git_id is not null");
            return (Criteria) this;
        }

        public Criteria andGitIdEqualTo(Integer value) {
            addCriterion("git_id =", value, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdNotEqualTo(Integer value) {
            addCriterion("git_id <>", value, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdGreaterThan(Integer value) {
            addCriterion("git_id >", value, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("git_id >=", value, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdLessThan(Integer value) {
            addCriterion("git_id <", value, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdLessThanOrEqualTo(Integer value) {
            addCriterion("git_id <=", value, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdIn(List<Integer> values) {
            addCriterion("git_id in", values, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdNotIn(List<Integer> values) {
            addCriterion("git_id not in", values, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdBetween(Integer value1, Integer value2) {
            addCriterion("git_id between", value1, value2, "gitId");
            return (Criteria) this;
        }

        public Criteria andGitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("git_id not between", value1, value2, "gitId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andChildrenIsNull() {
            addCriterion("children is null");
            return (Criteria) this;
        }

        public Criteria andChildrenIsNotNull() {
            addCriterion("children is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenEqualTo(List value) {
            addChildrenCriterion("children =", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotEqualTo(List value) {
            addChildrenCriterion("children <>", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenGreaterThan(List value) {
            addChildrenCriterion("children >", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenGreaterThanOrEqualTo(List value) {
            addChildrenCriterion("children >=", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLessThan(List value) {
            addChildrenCriterion("children <", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLessThanOrEqualTo(List value) {
            addChildrenCriterion("children <=", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLike(List value) {
            addChildrenCriterion("children like", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotLike(List value) {
            addChildrenCriterion("children not like", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenIn(List<List> values) {
            addChildrenCriterion("children in", values, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotIn(List<List> values) {
            addChildrenCriterion("children not in", values, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenBetween(List value1, List value2) {
            addChildrenCriterion("children between", value1, value2, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotBetween(List value1, List value2) {
            addChildrenCriterion("children not between", value1, value2, "children");
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