package com.apiProxy.mbg.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacocoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JacocoExample() {
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
        protected List<Criterion> childrensCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            childrensCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getChildrensCriteria() {
            return childrensCriteria;
        }

        protected void addChildrensCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            childrensCriteria.add(new Criterion(condition, value, "com.apiProxy.typehandler.JacocoListTypeHandler"));
            allCriteria = null;
        }

        protected void addChildrensCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            childrensCriteria.add(new Criterion(condition, value1, value2, "com.apiProxy.typehandler.JacocoListTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                    || childrensCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(childrensCriteria);
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

        public Criteria andGitlabIdIsNull() {
            addCriterion("gitlab_id is null");
            return (Criteria) this;
        }

        public Criteria andGitlabIdIsNotNull() {
            addCriterion("gitlab_id is not null");
            return (Criteria) this;
        }

        public Criteria andGitlabIdEqualTo(Integer value) {
            addCriterion("gitlab_id =", value, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdNotEqualTo(Integer value) {
            addCriterion("gitlab_id <>", value, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdGreaterThan(Integer value) {
            addCriterion("gitlab_id >", value, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gitlab_id >=", value, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdLessThan(Integer value) {
            addCriterion("gitlab_id <", value, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdLessThanOrEqualTo(Integer value) {
            addCriterion("gitlab_id <=", value, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdIn(List<Integer> values) {
            addCriterion("gitlab_id in", values, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdNotIn(List<Integer> values) {
            addCriterion("gitlab_id not in", values, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdBetween(Integer value1, Integer value2) {
            addCriterion("gitlab_id between", value1, value2, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitlabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gitlab_id not between", value1, value2, "gitlabId");
            return (Criteria) this;
        }

        public Criteria andGitclonePathIsNull() {
            addCriterion("gitclone_path is null");
            return (Criteria) this;
        }

        public Criteria andGitclonePathIsNotNull() {
            addCriterion("gitclone_path is not null");
            return (Criteria) this;
        }

        public Criteria andGitclonePathEqualTo(String value) {
            addCriterion("gitclone_path =", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathNotEqualTo(String value) {
            addCriterion("gitclone_path <>", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathGreaterThan(String value) {
            addCriterion("gitclone_path >", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathGreaterThanOrEqualTo(String value) {
            addCriterion("gitclone_path >=", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathLessThan(String value) {
            addCriterion("gitclone_path <", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathLessThanOrEqualTo(String value) {
            addCriterion("gitclone_path <=", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathLike(String value) {
            addCriterion("gitclone_path like", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathNotLike(String value) {
            addCriterion("gitclone_path not like", value, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathIn(List<String> values) {
            addCriterion("gitclone_path in", values, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathNotIn(List<String> values) {
            addCriterion("gitclone_path not in", values, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathBetween(String value1, String value2) {
            addCriterion("gitclone_path between", value1, value2, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andGitclonePathNotBetween(String value1, String value2) {
            addCriterion("gitclone_path not between", value1, value2, "gitclonePath");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameIsNull() {
            addCriterion("jacoco_project_name is null");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameIsNotNull() {
            addCriterion("jacoco_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameEqualTo(String value) {
            addCriterion("jacoco_project_name =", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameNotEqualTo(String value) {
            addCriterion("jacoco_project_name <>", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameGreaterThan(String value) {
            addCriterion("jacoco_project_name >", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("jacoco_project_name >=", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameLessThan(String value) {
            addCriterion("jacoco_project_name <", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameLessThanOrEqualTo(String value) {
            addCriterion("jacoco_project_name <=", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameLike(String value) {
            addCriterion("jacoco_project_name like", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameNotLike(String value) {
            addCriterion("jacoco_project_name not like", value, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameIn(List<String> values) {
            addCriterion("jacoco_project_name in", values, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameNotIn(List<String> values) {
            addCriterion("jacoco_project_name not in", values, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameBetween(String value1, String value2) {
            addCriterion("jacoco_project_name between", value1, value2, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andJacocoProjectNameNotBetween(String value1, String value2) {
            addCriterion("jacoco_project_name not between", value1, value2, "jacocoProjectName");
            return (Criteria) this;
        }

        public Criteria andChildrensIsNull() {
            addCriterion("childrens is null");
            return (Criteria) this;
        }

        public Criteria andChildrensIsNotNull() {
            addCriterion("childrens is not null");
            return (Criteria) this;
        }

        public Criteria andChildrensEqualTo(List value) {
            addChildrensCriterion("childrens =", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensNotEqualTo(List value) {
            addChildrensCriterion("childrens <>", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensGreaterThan(List value) {
            addChildrensCriterion("childrens >", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensGreaterThanOrEqualTo(List value) {
            addChildrensCriterion("childrens >=", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensLessThan(List value) {
            addChildrensCriterion("childrens <", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensLessThanOrEqualTo(List value) {
            addChildrensCriterion("childrens <=", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensLike(List value) {
            addChildrensCriterion("childrens like", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensNotLike(List value) {
            addChildrensCriterion("childrens not like", value, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensIn(List<List> values) {
            addChildrensCriterion("childrens in", values, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensNotIn(List<List> values) {
            addChildrensCriterion("childrens not in", values, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensBetween(List value1, List value2) {
            addChildrensCriterion("childrens between", value1, value2, "childrens");
            return (Criteria) this;
        }

        public Criteria andChildrensNotBetween(List value1, List value2) {
            addChildrensCriterion("childrens not between", value1, value2, "childrens");
            return (Criteria) this;
        }

        public Criteria andCompareTypeIsNull() {
            addCriterion("compare_type is null");
            return (Criteria) this;
        }

        public Criteria andCompareTypeIsNotNull() {
            addCriterion("compare_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompareTypeEqualTo(Integer value) {
            addCriterion("compare_type =", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotEqualTo(Integer value) {
            addCriterion("compare_type <>", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeGreaterThan(Integer value) {
            addCriterion("compare_type >", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("compare_type >=", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeLessThan(Integer value) {
            addCriterion("compare_type <", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeLessThanOrEqualTo(Integer value) {
            addCriterion("compare_type <=", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeIn(List<Integer> values) {
            addCriterion("compare_type in", values, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotIn(List<Integer> values) {
            addCriterion("compare_type not in", values, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeBetween(Integer value1, Integer value2) {
            addCriterion("compare_type between", value1, value2, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("compare_type not between", value1, value2, "compareType");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchIsNull() {
            addCriterion("current_branch is null");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchIsNotNull() {
            addCriterion("current_branch is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchEqualTo(String value) {
            addCriterion("current_branch =", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchNotEqualTo(String value) {
            addCriterion("current_branch <>", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchGreaterThan(String value) {
            addCriterion("current_branch >", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchGreaterThanOrEqualTo(String value) {
            addCriterion("current_branch >=", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchLessThan(String value) {
            addCriterion("current_branch <", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchLessThanOrEqualTo(String value) {
            addCriterion("current_branch <=", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchLike(String value) {
            addCriterion("current_branch like", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchNotLike(String value) {
            addCriterion("current_branch not like", value, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchIn(List<String> values) {
            addCriterion("current_branch in", values, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchNotIn(List<String> values) {
            addCriterion("current_branch not in", values, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchBetween(String value1, String value2) {
            addCriterion("current_branch between", value1, value2, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentBranchNotBetween(String value1, String value2) {
            addCriterion("current_branch not between", value1, value2, "currentBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchIsNull() {
            addCriterion("compare_branch is null");
            return (Criteria) this;
        }

        public Criteria andCompareBranchIsNotNull() {
            addCriterion("compare_branch is not null");
            return (Criteria) this;
        }

        public Criteria andCompareBranchEqualTo(String value) {
            addCriterion("compare_branch =", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchNotEqualTo(String value) {
            addCriterion("compare_branch <>", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchGreaterThan(String value) {
            addCriterion("compare_branch >", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchGreaterThanOrEqualTo(String value) {
            addCriterion("compare_branch >=", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchLessThan(String value) {
            addCriterion("compare_branch <", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchLessThanOrEqualTo(String value) {
            addCriterion("compare_branch <=", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchLike(String value) {
            addCriterion("compare_branch like", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchNotLike(String value) {
            addCriterion("compare_branch not like", value, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchIn(List<String> values) {
            addCriterion("compare_branch in", values, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchNotIn(List<String> values) {
            addCriterion("compare_branch not in", values, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchBetween(String value1, String value2) {
            addCriterion("compare_branch between", value1, value2, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCompareBranchNotBetween(String value1, String value2) {
            addCriterion("compare_branch not between", value1, value2, "compareBranch");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitIsNull() {
            addCriterion("current_commit is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitIsNotNull() {
            addCriterion("current_commit is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitEqualTo(String value) {
            addCriterion("current_commit =", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitNotEqualTo(String value) {
            addCriterion("current_commit <>", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitGreaterThan(String value) {
            addCriterion("current_commit >", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitGreaterThanOrEqualTo(String value) {
            addCriterion("current_commit >=", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitLessThan(String value) {
            addCriterion("current_commit <", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitLessThanOrEqualTo(String value) {
            addCriterion("current_commit <=", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitLike(String value) {
            addCriterion("current_commit like", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitNotLike(String value) {
            addCriterion("current_commit not like", value, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitIn(List<String> values) {
            addCriterion("current_commit in", values, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitNotIn(List<String> values) {
            addCriterion("current_commit not in", values, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitBetween(String value1, String value2) {
            addCriterion("current_commit between", value1, value2, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCurrentCommitNotBetween(String value1, String value2) {
            addCriterion("current_commit not between", value1, value2, "currentCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitIsNull() {
            addCriterion("compare_commit is null");
            return (Criteria) this;
        }

        public Criteria andCompareCommitIsNotNull() {
            addCriterion("compare_commit is not null");
            return (Criteria) this;
        }

        public Criteria andCompareCommitEqualTo(String value) {
            addCriterion("compare_commit =", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitNotEqualTo(String value) {
            addCriterion("compare_commit <>", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitGreaterThan(String value) {
            addCriterion("compare_commit >", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitGreaterThanOrEqualTo(String value) {
            addCriterion("compare_commit >=", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitLessThan(String value) {
            addCriterion("compare_commit <", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitLessThanOrEqualTo(String value) {
            addCriterion("compare_commit <=", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitLike(String value) {
            addCriterion("compare_commit like", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitNotLike(String value) {
            addCriterion("compare_commit not like", value, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitIn(List<String> values) {
            addCriterion("compare_commit in", values, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitNotIn(List<String> values) {
            addCriterion("compare_commit not in", values, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitBetween(String value1, String value2) {
            addCriterion("compare_commit between", value1, value2, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andCompareCommitNotBetween(String value1, String value2) {
            addCriterion("compare_commit not between", value1, value2, "compareCommit");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andReportPathIsNull() {
            addCriterion("report_path is null");
            return (Criteria) this;
        }

        public Criteria andReportPathIsNotNull() {
            addCriterion("report_path is not null");
            return (Criteria) this;
        }

        public Criteria andReportPathEqualTo(String value) {
            addCriterion("report_path =", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotEqualTo(String value) {
            addCriterion("report_path <>", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathGreaterThan(String value) {
            addCriterion("report_path >", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathGreaterThanOrEqualTo(String value) {
            addCriterion("report_path >=", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLessThan(String value) {
            addCriterion("report_path <", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLessThanOrEqualTo(String value) {
            addCriterion("report_path <=", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLike(String value) {
            addCriterion("report_path like", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotLike(String value) {
            addCriterion("report_path not like", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathIn(List<String> values) {
            addCriterion("report_path in", values, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotIn(List<String> values) {
            addCriterion("report_path not in", values, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathBetween(String value1, String value2) {
            addCriterion("report_path between", value1, value2, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotBetween(String value1, String value2) {
            addCriterion("report_path not between", value1, value2, "reportPath");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
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