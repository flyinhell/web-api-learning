package com.eland.fromJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ResponseList {

    @SerializedName("search_id")
    @Expose
    private String searchId;
    @SerializedName("valid_count")
    @Expose
    private Integer validCount;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("query_time")
    @Expose
    private Double queryTime;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public Integer getValidCount() {
        return validCount;
    }

    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Double queryTime) {
        this.queryTime = queryTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("searchId", searchId).append("validCount", validCount).append("totalCount", totalCount).append("queryTime", queryTime).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalCount).append(validCount).append(searchId).append(queryTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponseList) == false) {
            return false;
        }
        ResponseList rhs = ((ResponseList) other);
        return new EqualsBuilder().append(totalCount, rhs.totalCount).append(validCount, rhs.validCount).append(searchId, rhs.searchId).append(queryTime, rhs.queryTime).isEquals();
    }

}