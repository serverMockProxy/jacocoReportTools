package com.apiProxy.mbg.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProxyDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProxyDetailsExample() {
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

        public Criteria andRequestJsonIsNull() {
            addCriterion("request_json is null");
            return (Criteria) this;
        }

        public Criteria andRequestJsonIsNotNull() {
            addCriterion("request_json is not null");
            return (Criteria) this;
        }

        public Criteria andRequestJsonEqualTo(String value) {
            addCriterion("request_json =", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonNotEqualTo(String value) {
            addCriterion("request_json <>", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonGreaterThan(String value) {
            addCriterion("request_json >", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonGreaterThanOrEqualTo(String value) {
            addCriterion("request_json >=", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonLessThan(String value) {
            addCriterion("request_json <", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonLessThanOrEqualTo(String value) {
            addCriterion("request_json <=", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonLike(String value) {
            addCriterion("request_json like", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonNotLike(String value) {
            addCriterion("request_json not like", value, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonIn(List<String> values) {
            addCriterion("request_json in", values, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonNotIn(List<String> values) {
            addCriterion("request_json not in", values, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonBetween(String value1, String value2) {
            addCriterion("request_json between", value1, value2, "requestJson");
            return (Criteria) this;
        }

        public Criteria andRequestJsonNotBetween(String value1, String value2) {
            addCriterion("request_json not between", value1, value2, "requestJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonIsNull() {
            addCriterion("response_json is null");
            return (Criteria) this;
        }

        public Criteria andResponseJsonIsNotNull() {
            addCriterion("response_json is not null");
            return (Criteria) this;
        }

        public Criteria andResponseJsonEqualTo(String value) {
            addCriterion("response_json =", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonNotEqualTo(String value) {
            addCriterion("response_json <>", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonGreaterThan(String value) {
            addCriterion("response_json >", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonGreaterThanOrEqualTo(String value) {
            addCriterion("response_json >=", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonLessThan(String value) {
            addCriterion("response_json <", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonLessThanOrEqualTo(String value) {
            addCriterion("response_json <=", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonLike(String value) {
            addCriterion("response_json like", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonNotLike(String value) {
            addCriterion("response_json not like", value, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonIn(List<String> values) {
            addCriterion("response_json in", values, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonNotIn(List<String> values) {
            addCriterion("response_json not in", values, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonBetween(String value1, String value2) {
            addCriterion("response_json between", value1, value2, "responseJson");
            return (Criteria) this;
        }

        public Criteria andResponseJsonNotBetween(String value1, String value2) {
            addCriterion("response_json not between", value1, value2, "responseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNull() {
            addCriterion("callback_url is null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNotNull() {
            addCriterion("callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlEqualTo(String value) {
            addCriterion("callback_url =", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotEqualTo(String value) {
            addCriterion("callback_url <>", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThan(String value) {
            addCriterion("callback_url >", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("callback_url >=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThan(String value) {
            addCriterion("callback_url <", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("callback_url <=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLike(String value) {
            addCriterion("callback_url like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotLike(String value) {
            addCriterion("callback_url not like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIn(List<String> values) {
            addCriterion("callback_url in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotIn(List<String> values) {
            addCriterion("callback_url not in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlBetween(String value1, String value2) {
            addCriterion("callback_url between", value1, value2, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("callback_url not between", value1, value2, "callbackUrl");
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

        public Criteria andCallbackRequestJsonIsNull() {
            addCriterion("callback_request_json is null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonIsNotNull() {
            addCriterion("callback_request_json is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonEqualTo(String value) {
            addCriterion("callback_request_json =", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotEqualTo(String value) {
            addCriterion("callback_request_json <>", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonGreaterThan(String value) {
            addCriterion("callback_request_json >", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonGreaterThanOrEqualTo(String value) {
            addCriterion("callback_request_json >=", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonLessThan(String value) {
            addCriterion("callback_request_json <", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonLessThanOrEqualTo(String value) {
            addCriterion("callback_request_json <=", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonLike(String value) {
            addCriterion("callback_request_json like", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotLike(String value) {
            addCriterion("callback_request_json not like", value, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonIn(List<String> values) {
            addCriterion("callback_request_json in", values, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotIn(List<String> values) {
            addCriterion("callback_request_json not in", values, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonBetween(String value1, String value2) {
            addCriterion("callback_request_json between", value1, value2, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackRequestJsonNotBetween(String value1, String value2) {
            addCriterion("callback_request_json not between", value1, value2, "callbackRequestJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonIsNull() {
            addCriterion("callback_response_json is null");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonIsNotNull() {
            addCriterion("callback_response_json is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonEqualTo(String value) {
            addCriterion("callback_response_json =", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonNotEqualTo(String value) {
            addCriterion("callback_response_json <>", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonGreaterThan(String value) {
            addCriterion("callback_response_json >", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonGreaterThanOrEqualTo(String value) {
            addCriterion("callback_response_json >=", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonLessThan(String value) {
            addCriterion("callback_response_json <", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonLessThanOrEqualTo(String value) {
            addCriterion("callback_response_json <=", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonLike(String value) {
            addCriterion("callback_response_json like", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonNotLike(String value) {
            addCriterion("callback_response_json not like", value, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonIn(List<String> values) {
            addCriterion("callback_response_json in", values, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonNotIn(List<String> values) {
            addCriterion("callback_response_json not in", values, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonBetween(String value1, String value2) {
            addCriterion("callback_response_json between", value1, value2, "callbackResponseJson");
            return (Criteria) this;
        }

        public Criteria andCallbackResponseJsonNotBetween(String value1, String value2) {
            addCriterion("callback_response_json not between", value1, value2, "callbackResponseJson");
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

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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