package com.eland.jsonCreator;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FieldFilter {

    @SerializedName("and")
    @Expose
    private List<FieldFilterSituation> and = null;

    public List<FieldFilterSituation> getAnd() {
        return and;
    }

    public void setAnd(List<FieldFilterSituation> and) {
        this.and = and;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("and", and).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(and).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FieldFilter) == false) {
            return false;
        }
        FieldFilter rhs = ((FieldFilter) other);
        return new EqualsBuilder().append(and, rhs.and).isEquals();
    }

}