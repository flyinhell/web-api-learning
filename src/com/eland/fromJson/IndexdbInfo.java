package com.eland.fromJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class IndexdbInfo {

    @SerializedName("WH_Forum_1%201712%")
    @Expose
    private Integer wHForum1201712;
    @SerializedName("WH_Bbs_1%201712%")
    @Expose
    private Integer wHBbs1201712;

    public Integer getWHForum1201712() {
        return wHForum1201712;
    }

    public void setWHForum1201712(Integer wHForum1201712) {
        this.wHForum1201712 = wHForum1201712;
    }

    public Integer getWHBbs1201712() {
        return wHBbs1201712;
    }

    public void setWHBbs1201712(Integer wHBbs1201712) {
        this.wHBbs1201712 = wHBbs1201712;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("wHForum1201712", wHForum1201712).append("wHBbs1201712", wHBbs1201712).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(wHBbs1201712).append(wHForum1201712).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IndexdbInfo) == false) {
            return false;
        }
        IndexdbInfo rhs = ((IndexdbInfo) other);
        return new EqualsBuilder().append(wHBbs1201712, rhs.wHBbs1201712).append(wHForum1201712, rhs.wHForum1201712).isEquals();
    }

}