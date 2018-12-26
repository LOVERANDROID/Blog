package com.blog.model;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentViewIsNull() {
            addCriterion("comment_view is null");
            return (Criteria) this;
        }

        public Criteria andCommentViewIsNotNull() {
            addCriterion("comment_view is not null");
            return (Criteria) this;
        }

        public Criteria andCommentViewEqualTo(String value) {
            addCriterion("comment_view =", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewNotEqualTo(String value) {
            addCriterion("comment_view <>", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewGreaterThan(String value) {
            addCriterion("comment_view >", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewGreaterThanOrEqualTo(String value) {
            addCriterion("comment_view >=", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewLessThan(String value) {
            addCriterion("comment_view <", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewLessThanOrEqualTo(String value) {
            addCriterion("comment_view <=", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewLike(String value) {
            addCriterion("comment_view like", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewNotLike(String value) {
            addCriterion("comment_view not like", value, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewIn(List<String> values) {
            addCriterion("comment_view in", values, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewNotIn(List<String> values) {
            addCriterion("comment_view not in", values, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewBetween(String value1, String value2) {
            addCriterion("comment_view between", value1, value2, "commentView");
            return (Criteria) this;
        }

        public Criteria andCommentViewNotBetween(String value1, String value2) {
            addCriterion("comment_view not between", value1, value2, "commentView");
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

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andCommentIpIsNull() {
            addCriterion("comment_ip is null");
            return (Criteria) this;
        }

        public Criteria andCommentIpIsNotNull() {
            addCriterion("comment_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIpEqualTo(String value) {
            addCriterion("comment_ip =", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotEqualTo(String value) {
            addCriterion("comment_ip <>", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpGreaterThan(String value) {
            addCriterion("comment_ip >", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpGreaterThanOrEqualTo(String value) {
            addCriterion("comment_ip >=", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpLessThan(String value) {
            addCriterion("comment_ip <", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpLessThanOrEqualTo(String value) {
            addCriterion("comment_ip <=", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpLike(String value) {
            addCriterion("comment_ip like", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotLike(String value) {
            addCriterion("comment_ip not like", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpIn(List<String> values) {
            addCriterion("comment_ip in", values, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotIn(List<String> values) {
            addCriterion("comment_ip not in", values, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpBetween(String value1, String value2) {
            addCriterion("comment_ip between", value1, value2, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotBetween(String value1, String value2) {
            addCriterion("comment_ip not between", value1, value2, "commentIp");
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