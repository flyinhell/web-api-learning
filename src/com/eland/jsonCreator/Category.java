package com.eland.jsonCreator;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Category {

    @SerializedName("and")
    @Expose
    private List<String> and = null;
    @SerializedName("sort")
    @Expose
    private Sort sort;
    @SerializedName("depth")
    @Expose
    private Integer depth;

    public List<String> getAnd() {
        return and;
    }

    public void setAnd(List<String> and) {
        this.and = and;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("and", and).append("sort", sort).append("depth", depth).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sort).append(depth).append(and).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return new EqualsBuilder().append(sort, rhs.sort).append(depth, rhs.depth).append(and, rhs.and).isEquals();
    }

}