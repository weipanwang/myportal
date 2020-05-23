package my.portal.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BloggerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BloggerExample() {
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

        public Criteria andBloggerIdIsNull() {
            addCriterion("blogger_id is null");
            return (Criteria) this;
        }

        public Criteria andBloggerIdIsNotNull() {
            addCriterion("blogger_id is not null");
            return (Criteria) this;
        }

        public Criteria andBloggerIdEqualTo(Long value) {
            addCriterion("blogger_id =", value, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdNotEqualTo(Long value) {
            addCriterion("blogger_id <>", value, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdGreaterThan(Long value) {
            addCriterion("blogger_id >", value, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("blogger_id >=", value, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdLessThan(Long value) {
            addCriterion("blogger_id <", value, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdLessThanOrEqualTo(Long value) {
            addCriterion("blogger_id <=", value, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdIn(List<Long> values) {
            addCriterion("blogger_id in", values, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdNotIn(List<Long> values) {
            addCriterion("blogger_id not in", values, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdBetween(Long value1, Long value2) {
            addCriterion("blogger_id between", value1, value2, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerIdNotBetween(Long value1, Long value2) {
            addCriterion("blogger_id not between", value1, value2, "bloggerId");
            return (Criteria) this;
        }

        public Criteria andBloggerNameIsNull() {
            addCriterion("blogger_name is null");
            return (Criteria) this;
        }

        public Criteria andBloggerNameIsNotNull() {
            addCriterion("blogger_name is not null");
            return (Criteria) this;
        }

        public Criteria andBloggerNameEqualTo(String value) {
            addCriterion("blogger_name =", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameNotEqualTo(String value) {
            addCriterion("blogger_name <>", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameGreaterThan(String value) {
            addCriterion("blogger_name >", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameGreaterThanOrEqualTo(String value) {
            addCriterion("blogger_name >=", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameLessThan(String value) {
            addCriterion("blogger_name <", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameLessThanOrEqualTo(String value) {
            addCriterion("blogger_name <=", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameLike(String value) {
            addCriterion("blogger_name like", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameNotLike(String value) {
            addCriterion("blogger_name not like", value, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameIn(List<String> values) {
            addCriterion("blogger_name in", values, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameNotIn(List<String> values) {
            addCriterion("blogger_name not in", values, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameBetween(String value1, String value2) {
            addCriterion("blogger_name between", value1, value2, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerNameNotBetween(String value1, String value2) {
            addCriterion("blogger_name not between", value1, value2, "bloggerName");
            return (Criteria) this;
        }

        public Criteria andBloggerCityIsNull() {
            addCriterion("blogger_city is null");
            return (Criteria) this;
        }

        public Criteria andBloggerCityIsNotNull() {
            addCriterion("blogger_city is not null");
            return (Criteria) this;
        }

        public Criteria andBloggerCityEqualTo(String value) {
            addCriterion("blogger_city =", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityNotEqualTo(String value) {
            addCriterion("blogger_city <>", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityGreaterThan(String value) {
            addCriterion("blogger_city >", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityGreaterThanOrEqualTo(String value) {
            addCriterion("blogger_city >=", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityLessThan(String value) {
            addCriterion("blogger_city <", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityLessThanOrEqualTo(String value) {
            addCriterion("blogger_city <=", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityLike(String value) {
            addCriterion("blogger_city like", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityNotLike(String value) {
            addCriterion("blogger_city not like", value, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityIn(List<String> values) {
            addCriterion("blogger_city in", values, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityNotIn(List<String> values) {
            addCriterion("blogger_city not in", values, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityBetween(String value1, String value2) {
            addCriterion("blogger_city between", value1, value2, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerCityNotBetween(String value1, String value2) {
            addCriterion("blogger_city not between", value1, value2, "bloggerCity");
            return (Criteria) this;
        }

        public Criteria andBloggerShowIsNull() {
            addCriterion("blogger_show is null");
            return (Criteria) this;
        }

        public Criteria andBloggerShowIsNotNull() {
            addCriterion("blogger_show is not null");
            return (Criteria) this;
        }

        public Criteria andBloggerShowEqualTo(String value) {
            addCriterion("blogger_show =", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowNotEqualTo(String value) {
            addCriterion("blogger_show <>", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowGreaterThan(String value) {
            addCriterion("blogger_show >", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowGreaterThanOrEqualTo(String value) {
            addCriterion("blogger_show >=", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowLessThan(String value) {
            addCriterion("blogger_show <", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowLessThanOrEqualTo(String value) {
            addCriterion("blogger_show <=", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowLike(String value) {
            addCriterion("blogger_show like", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowNotLike(String value) {
            addCriterion("blogger_show not like", value, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowIn(List<String> values) {
            addCriterion("blogger_show in", values, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowNotIn(List<String> values) {
            addCriterion("blogger_show not in", values, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowBetween(String value1, String value2) {
            addCriterion("blogger_show between", value1, value2, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerShowNotBetween(String value1, String value2) {
            addCriterion("blogger_show not between", value1, value2, "bloggerShow");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadIsNull() {
            addCriterion("blogger_head is null");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadIsNotNull() {
            addCriterion("blogger_head is not null");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadEqualTo(String value) {
            addCriterion("blogger_head =", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadNotEqualTo(String value) {
            addCriterion("blogger_head <>", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadGreaterThan(String value) {
            addCriterion("blogger_head >", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadGreaterThanOrEqualTo(String value) {
            addCriterion("blogger_head >=", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadLessThan(String value) {
            addCriterion("blogger_head <", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadLessThanOrEqualTo(String value) {
            addCriterion("blogger_head <=", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadLike(String value) {
            addCriterion("blogger_head like", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadNotLike(String value) {
            addCriterion("blogger_head not like", value, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadIn(List<String> values) {
            addCriterion("blogger_head in", values, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadNotIn(List<String> values) {
            addCriterion("blogger_head not in", values, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadBetween(String value1, String value2) {
            addCriterion("blogger_head between", value1, value2, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andBloggerHeadNotBetween(String value1, String value2) {
            addCriterion("blogger_head not between", value1, value2, "bloggerHead");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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