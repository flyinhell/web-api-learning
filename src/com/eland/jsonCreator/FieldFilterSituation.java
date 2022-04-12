package com.eland.jsonCreator;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FieldFilterSituation {

    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("condition")
    @Expose
    private String condition;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("field", field).append("condition", condition).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(field).append(condition).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FieldFilterSituation) == false) {
            return false;
        }
        FieldFilterSituation rhs = ((FieldFilterSituation) other);
        return new EqualsBuilder().append(field, rhs.field).append(condition, rhs.condition).isEquals();
    }

}