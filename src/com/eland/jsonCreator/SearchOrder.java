 package com.eland.jsonCreator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchOrder {

    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("order_type")
    @Expose
    private String orderType;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("field", field).append("orderType", orderType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(field).append(orderType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchOrder) == false) {
            return false;
        }
        SearchOrder rhs = ((SearchOrder) other);
        return new EqualsBuilder().append(field, rhs.field).append(orderType, rhs.orderType).isEquals();
    }

}