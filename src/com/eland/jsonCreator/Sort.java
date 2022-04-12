package com.eland.jsonCreator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Sort {

    @SerializedName("order_type")
    @Expose
    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("orderType", orderType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(orderType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sort) == false) {
            return false;
        }
        Sort rhs = ((Sort) other);
        return new EqualsBuilder().append(orderType, rhs.orderType).isEquals();
    }

}