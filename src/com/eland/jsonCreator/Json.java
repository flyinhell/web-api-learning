package com.eland.jsonCreator;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Json {

    @SerializedName("query_type")
    @Expose
    private String queryType;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("field_filter")
    @Expose
    private FieldFilter fieldFilter;
    @SerializedName("target_db")
    @Expose
    private List<String> targetDb = null;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("search_range")
    @Expose
    private SearchRange searchRange;
    @SerializedName("search_order")
    @Expose
    private List<SearchOrder> searchOrder = null;
    @SerializedName("result_field")
    @Expose
    private List<String> resultField = null;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public FieldFilter getFieldFilter() {
        return fieldFilter;
    }

    public void setFieldFilter(FieldFilter fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public List<String> getTargetDb() {
        return targetDb;
    }

    public void setTargetDb(List<String> targetDb) {
        this.targetDb = targetDb;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SearchRange getSearchRange() {
        return searchRange;
    }

    public void setSearchRange(SearchRange searchRange) {
        this.searchRange = searchRange;
    }

    public List<SearchOrder> getSearchOrder() {
        return searchOrder;
    }

    public void setSearchOrder(List<SearchOrder> searchOrder) {
        this.searchOrder = searchOrder;
    }

    public List<String> getResultField() {
        return resultField;
    }

    public void setResultField(List<String> resultField) {
        this.resultField = resultField;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("queryType", queryType).append("keyword", keyword).append("fieldFilter", fieldFilter).append("targetDb", targetDb).append("category", category).append("searchRange", searchRange).append("searchOrder", searchOrder).append("resultField", resultField).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(searchOrder).append(queryType).append(searchRange).append(category).append(keyword).append(targetDb).append(resultField).append(fieldFilter).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Json) == false) {
            return false;
        }
        Json rhs = ((Json) other);
        return new EqualsBuilder().append(searchOrder, rhs.searchOrder).append(queryType, rhs.queryType).append(searchRange, rhs.searchRange).append(category, rhs.category).append(keyword, rhs.keyword).append(targetDb, rhs.targetDb).append(resultField, rhs.resultField).append(fieldFilter, rhs.fieldFilter).isEquals();
    }

}
