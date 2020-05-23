package my.portal.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Long value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Long value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Long value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Long value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Long value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Long> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Long> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Long value1, Long value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Long value1, Long value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIsNull() {
            addCriterion("blog_author is null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIsNotNull() {
            addCriterion("blog_author is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorEqualTo(String value) {
            addCriterion("blog_author =", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotEqualTo(String value) {
            addCriterion("blog_author <>", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorGreaterThan(String value) {
            addCriterion("blog_author >", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("blog_author >=", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorLessThan(String value) {
            addCriterion("blog_author <", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorLessThanOrEqualTo(String value) {
            addCriterion("blog_author <=", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorLike(String value) {
            addCriterion("blog_author like", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotLike(String value) {
            addCriterion("blog_author not like", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIn(List<String> values) {
            addCriterion("blog_author in", values, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotIn(List<String> values) {
            addCriterion("blog_author not in", values, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorBetween(String value1, String value2) {
            addCriterion("blog_author between", value1, value2, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotBetween(String value1, String value2) {
            addCriterion("blog_author not between", value1, value2, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoIsNull() {
            addCriterion("blog_photo is null");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoIsNotNull() {
            addCriterion("blog_photo is not null");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoEqualTo(String value) {
            addCriterion("blog_photo =", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoNotEqualTo(String value) {
            addCriterion("blog_photo <>", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoGreaterThan(String value) {
            addCriterion("blog_photo >", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("blog_photo >=", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoLessThan(String value) {
            addCriterion("blog_photo <", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoLessThanOrEqualTo(String value) {
            addCriterion("blog_photo <=", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoLike(String value) {
            addCriterion("blog_photo like", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoNotLike(String value) {
            addCriterion("blog_photo not like", value, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoIn(List<String> values) {
            addCriterion("blog_photo in", values, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoNotIn(List<String> values) {
            addCriterion("blog_photo not in", values, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoBetween(String value1, String value2) {
            addCriterion("blog_photo between", value1, value2, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogPhotoNotBetween(String value1, String value2) {
            addCriterion("blog_photo not between", value1, value2, "blogPhoto");
            return (Criteria) this;
        }

        public Criteria andBlogSortIsNull() {
            addCriterion("blog_sort is null");
            return (Criteria) this;
        }

        public Criteria andBlogSortIsNotNull() {
            addCriterion("blog_sort is not null");
            return (Criteria) this;
        }

        public Criteria andBlogSortEqualTo(String value) {
            addCriterion("blog_sort =", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortNotEqualTo(String value) {
            addCriterion("blog_sort <>", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortGreaterThan(String value) {
            addCriterion("blog_sort >", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortGreaterThanOrEqualTo(String value) {
            addCriterion("blog_sort >=", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortLessThan(String value) {
            addCriterion("blog_sort <", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortLessThanOrEqualTo(String value) {
            addCriterion("blog_sort <=", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortLike(String value) {
            addCriterion("blog_sort like", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortNotLike(String value) {
            addCriterion("blog_sort not like", value, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortIn(List<String> values) {
            addCriterion("blog_sort in", values, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortNotIn(List<String> values) {
            addCriterion("blog_sort not in", values, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortBetween(String value1, String value2) {
            addCriterion("blog_sort between", value1, value2, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSortNotBetween(String value1, String value2) {
            addCriterion("blog_sort not between", value1, value2, "blogSort");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberIsNull() {
            addCriterion("blog_see_number is null");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberIsNotNull() {
            addCriterion("blog_see_number is not null");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberEqualTo(Long value) {
            addCriterion("blog_see_number =", value, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberNotEqualTo(Long value) {
            addCriterion("blog_see_number <>", value, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberGreaterThan(Long value) {
            addCriterion("blog_see_number >", value, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_see_number >=", value, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberLessThan(Long value) {
            addCriterion("blog_see_number <", value, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberLessThanOrEqualTo(Long value) {
            addCriterion("blog_see_number <=", value, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberIn(List<Long> values) {
            addCriterion("blog_see_number in", values, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberNotIn(List<Long> values) {
            addCriterion("blog_see_number not in", values, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberBetween(Long value1, Long value2) {
            addCriterion("blog_see_number between", value1, value2, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogSeeNumberNotBetween(Long value1, Long value2) {
            addCriterion("blog_see_number not between", value1, value2, "blogSeeNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberIsNull() {
            addCriterion("blog_comment_number is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberIsNotNull() {
            addCriterion("blog_comment_number is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberEqualTo(Long value) {
            addCriterion("blog_comment_number =", value, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberNotEqualTo(Long value) {
            addCriterion("blog_comment_number <>", value, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberGreaterThan(Long value) {
            addCriterion("blog_comment_number >", value, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_comment_number >=", value, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberLessThan(Long value) {
            addCriterion("blog_comment_number <", value, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberLessThanOrEqualTo(Long value) {
            addCriterion("blog_comment_number <=", value, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberIn(List<Long> values) {
            addCriterion("blog_comment_number in", values, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberNotIn(List<Long> values) {
            addCriterion("blog_comment_number not in", values, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberBetween(Long value1, Long value2) {
            addCriterion("blog_comment_number between", value1, value2, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCommentNumberNotBetween(Long value1, Long value2) {
            addCriterion("blog_comment_number not between", value1, value2, "blogCommentNumber");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedIsNull() {
            addCriterion("blog_created is null");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedIsNotNull() {
            addCriterion("blog_created is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedEqualTo(Date value) {
            addCriterion("blog_created =", value, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedNotEqualTo(Date value) {
            addCriterion("blog_created <>", value, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedGreaterThan(Date value) {
            addCriterion("blog_created >", value, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_created >=", value, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedLessThan(Date value) {
            addCriterion("blog_created <", value, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedLessThanOrEqualTo(Date value) {
            addCriterion("blog_created <=", value, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedIn(List<Date> values) {
            addCriterion("blog_created in", values, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedNotIn(List<Date> values) {
            addCriterion("blog_created not in", values, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedBetween(Date value1, Date value2) {
            addCriterion("blog_created between", value1, value2, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogCreatedNotBetween(Date value1, Date value2) {
            addCriterion("blog_created not between", value1, value2, "blogCreated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedIsNull() {
            addCriterion("blog_updated is null");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedIsNotNull() {
            addCriterion("blog_updated is not null");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedEqualTo(Date value) {
            addCriterion("blog_updated =", value, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedNotEqualTo(Date value) {
            addCriterion("blog_updated <>", value, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedGreaterThan(Date value) {
            addCriterion("blog_updated >", value, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_updated >=", value, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedLessThan(Date value) {
            addCriterion("blog_updated <", value, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("blog_updated <=", value, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedIn(List<Date> values) {
            addCriterion("blog_updated in", values, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedNotIn(List<Date> values) {
            addCriterion("blog_updated not in", values, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedBetween(Date value1, Date value2) {
            addCriterion("blog_updated between", value1, value2, "blogUpdated");
            return (Criteria) this;
        }

        public Criteria andBlogUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("blog_updated not between", value1, value2, "blogUpdated");
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