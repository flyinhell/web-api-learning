package com.eland.jsonCreator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchRange {

    @SerializedName("start_pos")
    @Expose
    private Integer startPos;
    @SerializedName("max_record")
    @Expose
    private Integer maxRecord;

    public Integer getStartPos() {
        return startPos;
    }

    public void setStartPos(Integer startPos) {
        this.startPos = startPos;
    }

    public Integer getMaxRecord() {
        return maxRecord;
    }

    public void setMaxRecord(Integer maxRecord) {
        this.maxRecord = maxRecord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startPos", startPos).append("maxRecord", maxRecord).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startPos).append(maxRecord).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchRange) == false) {
            return false;
        }
        SearchRange rhs = ((SearchRange) other);
        return new EqualsBuilder().append(startPos, rhs.startPos).append(maxRecord, rhs.maxRecord).isEquals();
    }

}