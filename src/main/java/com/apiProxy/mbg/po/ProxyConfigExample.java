package com.apiProxy.mbg.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProxyConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProxyConfigExample() {
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
        protected List<Criterion> callbackHeadersCriteria;

        protected List<Criterion> callbackRequestJsonCriteria;

        protected List<Criterion> callbackRequestQueryCriteria;

        protected List<Criterion> callbackRequestFormCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            callbackHeadersCriteria = new ArrayList<Criterion>();
            callbackRequestJsonCriteria = new ArrayList<Criterion>();
            callbackRequestQueryCriteria = new ArrayList<Criterion>();
            callbackRequestFormCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getCallbackHeadersCriteria() {
            return callbackHeadersCriteria;
        }

        protected void addCallbackHeadersCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            callbackHeadersCriteria.add(new Criterion(condition, value, "com.apiProxy.typehandler.ApiHeadersListTypeHandler"));
            allCriteria = null;
        }

        protected void addCallbackHeadersCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            callbackHeadersCriteria.add(new Criterion(condition, value1, value2, "com.apiProxy.typehandler.ApiHeadersListTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getCallbackRequestJsonCriteria() {
            return callbackRequestJsonCriteria;
        }

        protected void addCallbackRequestJsonCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            callbackRequestJsonCriteria.add(new Criterion(condition, value, "com.apiProxy.typehandler.JsonBodyListTypeHandler"));
            allCriteria = null;
        }

        protected void addCallbackRequestJsonCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            callbackRequestJsonCriteria.add(new Criterion(condition, value1, value2, "com.apiProxy.typehandler.JsonBodyListTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getCallbackRequestQueryCriteria() {
            return callbackRequestQueryCriteria;
        }

        protected void addCallbackRequestQueryCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            callbackRequestQueryCriteria.add(new Criterion(condition, value, "com.apiProxy.typehandler.QueryBodyListTypeHandler"));
            allCriteria = null;
        }

        protected void addCallbackRequestQueryCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            callbackRequestQueryCriteria.add(new Criterion(condition, value1, value2, "com.apiProxy.typehandler.QueryBodyListTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getCallbackRequestFormCriteria() {
            return callbackRequestFormCriteria;
        }

        protected void addCallbackRequestFormCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            callbackRequestFormCriteria.add(new Criterion(condition, value, "com.apiProxy.typehandler.QueryBodyListTypeHandler"));
            allCriteria = null;
        }

        protected void addCallbackRequestFormCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            callbackRequestFormCriteria.add(new Criterion(condition, value1, value2, "com.apiProxy.typehandler.QueryBodyListTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                    || callbackHeadersCriteria.size() > 0
                    || callbackRequestJsonCriteria.size() > 0
                    || callbackRequestQueryCriteria.size() > 0
                    || callbackRequestFormCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(callbackHeadersCriteria);
                allCriteria.addAll(callbackRequestJsonCriteria);
                allCriteria.addAll(callbackRequestQueryCriteria);
                allCriteria.addAll(callbackRequestFormCriteria);
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

        public Criteria andInterceptPathIsNull() {
            addCriterion("intercept_path is null");
            return (Criteria) this;
        }

        public Criteria andInterceptPathIsNotNull() {
            addCriterion("intercept_path is not null");
            return (Criteria) this;
        }

        public Criteria andInterceptPathEqualTo(String value) {
            addCriterion("intercept_path =", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathNotEqualTo(String value) {
            addCriterion("intercept_path <>", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathGreaterThan(String value) {
            addCriterion("intercept_path >", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathGreaterThanOrEqualTo(String value) {
            addCriterion("intercept_path >=", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathLessThan(String value) {
            addCriterion("intercept_path <", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathLessThanOrEqualTo(String value) {
            addCriterion("intercept_path <=", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathLike(String value) {
            addCriterion("intercept_path like", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathNotLike(String value) {
            addCriterion("intercept_path not like", value, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathIn(List<String> values) {
            addCriterion("intercept_path in", values, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathNotIn(List<String> values) {
            addCriterion("intercept_path not in", values, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathBetween(String value1, String value2) {
            addCriterion("intercept_path between", value1, value2, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andInterceptPathNotBetween(String value1, String value2) {
            addCriterion("intercept_path not between", value1, value2, "interceptPath");
            return (Criteria) this;
        }

        public Criteria andForwardHostIsNull() {
            addCriterion("forward_host is null");
            return (Criteria) this;
        }

        public Criteria andForwardHostIsNotNull() {
            addCriterion("forward_host is not null");
            return (Criteria) this;
        }

        public Criteria andForwardHostEqualTo(String value) {
            addCriterion("forward_host =", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostNotEqualTo(String value) {
            addCriterion("forward_host <>", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostGreaterThan(String value) {
            addCriterion("forward_host >", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostGreaterThanOrEqualTo(String value) {
            addCriterion("forward_host >=", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostLessThan(String value) {
            addCriterion("forward_host <", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostLessThanOrEqualTo(String value) {
            addCriterion("forward_host <=", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostLike(String value) {
            addCriterion("forward_host like", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostNotLike(String value) {
            addCriterion("forward_host not like", value, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostIn(List<String> values) {
            addCriterion("forward_host in", values, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostNotIn(List<String> values) {
            addCriterion("forward_host not in", values, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostBetween(String value1, String value2) {
            addCriterion("forward_host between", value1, value2, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andForwardHostNotBetween(String value1, String value2) {
            addCriterion("forward_host not between", value1, value2, "forwardHost");
            return (Criteria) this;
        }

        public Criteria andMockRequirIsNull() {
            addCriterion("mock_requir is null");
            return (Criteria) this;
        }

        public Criteria andMockRequirIsNotNull() {
            addCriterion("mock_requir is not null");
            return (Criteria) this;
        }

        public Criteria andMockRequirEqualTo(String value) {
            addCriterion("mock_requir =", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirNotEqualTo(String value) {
            addCriterion("mock_requir <>", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirGreaterThan(String value) {
            addCriterion("mock_requir >", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirGreaterThanOrEqualTo(String value) {
            addCriterion("mock_requir >=", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirLessThan(String value) {
            addCriterion("mock_requir <", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirLessThanOrEqualTo(String value) {
            addCriterion("mock_requir <=", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirLike(String value) {
            addCriterion("mock_requir like", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirNotLike(String value) {
            addCriterion("mock_requir not like", value, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirIn(List<String> values) {
            addCriterion("mock_requir in", values, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirNotIn(List<String> values) {
            addCriterion("mock_requir not in", values, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirBetween(String value1, String value2) {
            addCriterion("mock_requir between", value1, value2, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockRequirNotBetween(String value1, String value2) {
            addCriterion("mock_requir not between", value1, value2, "mockRequir");
            return (Criteria) this;
        }

        public Criteria andMockResponseIsNull() {
            addCriterion("mock_response is null");
            return (Criteria) this;
        }

        public Criteria andMockResponseIsNotNull() {
            addCriterion("mock_response is not null");
            return (Criteria) this;
        }

        public Criteria andMockResponseEqualTo(String value) {
            addCriterion("mock_response =", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseNotEqualTo(String value) {
            addCriterion("mock_response <>", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseGreaterThan(String value) {
            addCriterion("mock_response >", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseGreaterThanOrEqualTo(String value) {
            addCriterion("mock_response >=", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseLessThan(String value) {
            addCriterion("mock_response <", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseLessThanOrEqualTo(String value) {
            addCriterion("mock_response <=", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseLike(String value) {
            addCriterion("mock_response like", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseNotLike(String value) {
            addCriterion("mock_response not like", value, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseIn(List<String> values) {
            addCriterion("mock_response in", values, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseNotIn(List<String> values) {
            addCriterion("mock_response not in", values, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseBetween(String value1, String value2) {
            addCriterion("mock_response between", value1, value2, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andMockResponseNotBetween(String value1, String value2) {
            addCriterion("mock_response not between", value1, value2, "mockResponse");
            return (Criteria) this;
        }

        public Criteria andIsCallbackIsNull() {
            addCriterion("is_callback is null");
            return (Criteria) this;
        }

        public Criteria andIsCallbackIsNotNull() {
            addCriterion("is_callback is not null");
            return (Criteria) this;
        }

        public Criteria andIsCallbackEqualTo(Boolean value) {
            addCriterion("is_callback =", value, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackNotEqualTo(Boolean value) {
            addCriterion("is_callback <>", value, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackGreaterThan(Boolean value) {
            addCriterion("is_callback >", value, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_callback >=", value, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackLessThan(Boolean value) {
            addCriterion("is_callback <", value, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackLessThanOrEqualTo(Boolean value) {
            addCriterion("is_callback <=", value, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackIn(List<Boolean> values) {
            addCriterion("is_callback in", values, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackNotIn(List<Boolean> values) {
            addCriterion("is_callback not in", values, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackBetween(Boolean value1, Boolean value2) {
            addCriterion("is_callback between", value1, value2, "isCallback");
            return (Criteria) this;
        }

        public Criteria andIsCallbackNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_callback not between", value1, value2, "isCallback");
            return (Criteria) this;
        }

        public Criteria andCallbackHostIsNull() {
            addCriterion("callback_host is null");
            return (Criteria) this;
        }

        public Criteria andCallbackHostIsNotNull() {
            addCriterion("callback_host is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackHostEqualTo(String value) {
            addCriterion("callback_host =", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostNotEqualTo(String value) {
            addCriterion("callback_host <>", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostGreaterThan(String value) {
            addCriterion("callback_host >", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostGreaterThanOrEqualTo(String value) {
            addCriterion("callback_host >=", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostLessThan(String value) {
            addCriterion("callback_host <", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostLessThanOrEqualTo(String value) {
            addCriterion("callback_host <=", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostLike(String value) {
            addCriterion("callback_host like", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostNotLike(String value) {
            addCriterion("callback_host not like", value, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostIn(List<String> values) {
            addCriterion("callback_host in", values, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostNotIn(List<String> values) {
            addCriterion("callback_host not in", values, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostBetween(String value1, String value2) {
            addCriterion("callback_host between", value1, value2, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackHostNotBetween(String value1, String value2) {
            addCriterion("callback_host not between", value1, value2, "callbackHost");
            return (Criteria) this;
        }

        public Criteria andCallbackPathIsNull() {
            addCriterion("callback_path is null");
            return (Criteria) this;
        }

        public Criteria andCallbackPathIsNotNull() {
            addCriterion("callback_path is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackPathEqualTo(String value) {
            addCriterion("callback_path =", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathNotEqualTo(String value) {
            addCriterion("callback_path <>", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathGreaterThan(String value) {
            addCriterion("callback_path >", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathGreaterThanOrEqualTo(String value) {
            addCriterion("callback_path >=", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathLessThan(String value) {
            addCriterion("callback_path <", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathLessThanOrEqualTo(String value) {
            addCriterion("callback_path <=", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathLike(String value) {
            addCriterion("callback_path like", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathNotLike(String value) {
            addCriterion("callback_path not like", value, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathIn(List<String> values) {
            addCriterion("callback_path in", values, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathNotIn(List<String> values) {
            addCriterion("callback_path not in", values, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathBetween(String value1, String value2) {
            addCriterion("callback_path between", value1, value2, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackPathNotBetween(String value1, String value2) {
            addCriterion("callback_path not between", value1, value2, "callbackPath");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodIsNull() {
            addCriterion("callback_method is null");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodIsNotNull() {
            addCriterion("callback_method is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodEqualTo(String value) {
            addCriterion("callback_method =", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodNotEqualTo(String value) {
            addCriterion("callback_method <>", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodGreaterThan(String value) {
            addCriterion("callback_method >", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodGreaterThanOrEqualTo(String value) {
            addCriterion("callback_method >=", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodLessThan(String value) {
            addCriterion("callback_method <", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodLessThanOrEqualTo(String value) {
            addCriterion("callback_method <=", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodLike(String value) {
            addCriterion("callback_method like", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodNotLike(String value) {
            addCriterion("callback_method not like", value, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodIn(List<String> values) {
            addCriterion("callback_method in", values, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodNotIn(List<String> values) {
            addCriterion("callback_method not in", values, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodBetween(String value1, String value2) {
            addCriterion("callback_method between", value1, value2, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andCallbackMethodNotBetween(String value1, String value2) {
            addCriterion("callback_method not between", value1, value2, "callbackMethod");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNull() {
            addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(Integer value) {
            addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(Integer value) {
            addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(Integer value) {
            addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(Integer value) {
            addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sign_type <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<Integer> values) {
            addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<Integer> values) {
            addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(Integer value1, Integer value2) {
            addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_type not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNull() {
            addCriterion("client_secret is null");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNotNull() {
            addCriterion("client_secret is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecretEqualTo(String value) {
            addCriterion("client_secret =", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotEqualTo(String value) {
            addCriterion("client_secret <>", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThan(String value) {
            addCriterion("client_secret >", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThanOrEqualTo(String value) {
            addCriterion("client_secret >=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThan(String value) {
            addCriterion("client_secret <", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThanOrEqualTo(String value) {
            addCriterion("client_secret <=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLike(String value) {
            addCriterion("client_secret like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotLike(String value) {
            addCriterion("client_secret not like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretIn(List<String> values) {
            addCriterion("client_secret in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotIn(List<String> values) {
            addCriterion("client_secret not in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretBetween(String value1, String value2) {
            addCriterion("client_secret between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotBetween(String value1, String value2) {
            addCriterion("client_secret not between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeIsNull() {
            addCriterion("callback_body_type is null");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeIsNotNull() {
            addCriterion("callback_body_type is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeEqualTo(String value) {
            addCriterion("callback_body_type =", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeNotEqualTo(String value) {
            addCriterion("callback_body_type <>", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeGreaterThan(String value) {
            addCriterion("callback_body_type >", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("callback_body_type >=", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeLessThan(String value) {
            addCriterion("callback_body_type <", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeLessThanOrEqualTo(String value) {
            addCriterion("callback_body_type <=", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeLike(String value) {
            addCriterion("callback_body_type like", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeNotLike(String value) {
            addCriterion("callback_body_type not like", value, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeIn(List<String> values) {
            addCriterion("callback_body_type in", values, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeNotIn(List<String> values) {
            addCriterion("callback_body_type not in", values, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeBetween(String value1, String value2) {
            addCriterion("callback_body_type between", value1, value2, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackBodyTypeNotBetween(String value1, String value2) {
            addCriterion("callback_body_type not between", value1, value2, "callbackBodyType");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersIsNull() {
            addCriterion("callback_headers is null");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersIsNotNull() {
            addCriterion("callback_headers is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersEqualTo(List value) {
            addCallbackHeadersCriterion("callback_headers =", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersNotEqualTo(List value) {
            addCallbackHeadersCriterion("callback_headers <>", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersGreaterThan(List value) {
            addCallbackHeadersCriterion("callback_headers >", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersGreaterThanOrEqualTo(List value) {
            addCallbackHeadersCriterion("callback_headers >=", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersLessThan(List value) {
            addCallbackHeadersCriterion("callback_headers <", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersLessThanOrEqualTo(List value) {
            addCallbackHeadersCriterion("callback_headers <=", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersLike(List value) {
            addCallbackHeadersCriterion("callback_headers like", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersNotLike(List value) {
            addCallbackHeadersCriterion("callback_headers not like", value, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersIn(List<List> values) {
            addCallbackHeadersCriterion("callback_headers in", values, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersNotIn(List<List> values) {
            addCallbackHeadersCriterion("callback_headers not in", values, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersBetween(List value1, List value2) {
            addCallbackHeadersCriterion("callback_headers between", value1, value2, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackHeadersNotBetween(List value1, List value2) {
            addCallbackHeadersCriterion("callback_headers not between", value1, value2, "callbackHeaders");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonIsNull() {
            addCriterion("callback_request_json is null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonIsNotNull() {
            addCriterion("callback_request_json is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonEqualTo(List value) {
            addCallbackRequestJsonCriterion("callback_request_json =", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotEqualTo(List value) {
            addCallbackRequestJsonCriterion("callback_request_json <>", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonGreaterThan(List value) {
            addCallbackRequestJsonCriterion("callback_request_json >", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonGreaterThanOrEqualTo(List value) {
            addCallbackRequestJsonCriterion("callback_request_json >=", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonLessThan(List value) {
            addCallbackRequestJsonCriterion("callback_request_json <", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonLessThanOrEqualTo(List value) {
            addCallbackRequestJsonCriterion("callback_request_json <=", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonLike(List value) {
            addCallbackRequestJsonCriterion("callback_request_json like", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotLike(List value) {
            addCallbackRequestJsonCriterion("callback_request_json not like", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonIn(List<List> values) {
            addCallbackRequestJsonCriterion("callback_request_json in", values, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotIn(List<List> values) {
            addCallbackRequestJsonCriterion("callback_request_json not in", values, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonBetween(List value1, List value2) {
            addCallbackRequestJsonCriterion("callback_request_json between", value1, value2, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotBetween(List value1, List value2) {
            addCallbackRequestJsonCriterion("callback_request_json not between", value1, value2, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryIsNull() {
            addCriterion("callback_request_query is null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryIsNotNull() {
            addCriterion("callback_request_query is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryEqualTo(List value) {
            addCallbackRequestQueryCriterion("callback_request_query =", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryNotEqualTo(List value) {
            addCallbackRequestQueryCriterion("callback_request_query <>", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryGreaterThan(List value) {
            addCallbackRequestQueryCriterion("callback_request_query >", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryGreaterThanOrEqualTo(List value) {
            addCallbackRequestQueryCriterion("callback_request_query >=", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryLessThan(List value) {
            addCallbackRequestQueryCriterion("callback_request_query <", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryLessThanOrEqualTo(List value) {
            addCallbackRequestQueryCriterion("callback_request_query <=", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryLike(List value) {
            addCallbackRequestQueryCriterion("callback_request_query like", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryNotLike(List value) {
            addCallbackRequestQueryCriterion("callback_request_query not like", value, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryIn(List<List> values) {
            addCallbackRequestQueryCriterion("callback_request_query in", values, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryNotIn(List<List> values) {
            addCallbackRequestQueryCriterion("callback_request_query not in", values, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryBetween(List value1, List value2) {
            addCallbackRequestQueryCriterion("callback_request_query between", value1, value2, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestQueryNotBetween(List value1, List value2) {
            addCallbackRequestQueryCriterion("callback_request_query not between", value1, value2, "callbackRequestQuery");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormIsNull() {
            addCriterion("callback_request_form is null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormIsNotNull() {
            addCriterion("callback_request_form is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormEqualTo(List value) {
            addCallbackRequestFormCriterion("callback_request_form =", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormNotEqualTo(List value) {
            addCallbackRequestFormCriterion("callback_request_form <>", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormGreaterThan(List value) {
            addCallbackRequestFormCriterion("callback_request_form >", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormGreaterThanOrEqualTo(List value) {
            addCallbackRequestFormCriterion("callback_request_form >=", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormLessThan(List value) {
            addCallbackRequestFormCriterion("callback_request_form <", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormLessThanOrEqualTo(List value) {
            addCallbackRequestFormCriterion("callback_request_form <=", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormLike(List value) {
            addCallbackRequestFormCriterion("callback_request_form like", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormNotLike(List value) {
            addCallbackRequestFormCriterion("callback_request_form not like", value, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormIn(List<List> values) {
            addCallbackRequestFormCriterion("callback_request_form in", values, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormNotIn(List<List> values) {
            addCallbackRequestFormCriterion("callback_request_form not in", values, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormBetween(List value1, List value2) {
            addCallbackRequestFormCriterion("callback_request_form between", value1, value2, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestFormNotBetween(List value1, List value2) {
            addCallbackRequestFormCriterion("callback_request_form not between", value1, value2, "callbackRequestForm");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreatorUidIsNull() {
            addCriterion("creator_uid is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUidIsNotNull() {
            addCriterion("creator_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUidEqualTo(Integer value) {
            addCriterion("creator_uid =", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidNotEqualTo(Integer value) {
            addCriterion("creator_uid <>", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidGreaterThan(Integer value) {
            addCriterion("creator_uid >", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_uid >=", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidLessThan(Integer value) {
            addCriterion("creator_uid <", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidLessThanOrEqualTo(Integer value) {
            addCriterion("creator_uid <=", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidIn(List<Integer> values) {
            addCriterion("creator_uid in", values, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidNotIn(List<Integer> values) {
            addCriterion("creator_uid not in", values, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidBetween(Integer value1, Integer value2) {
            addCriterion("creator_uid between", value1, value2, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_uid not between", value1, value2, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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