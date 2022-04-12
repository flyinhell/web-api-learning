package com.eland.fromJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CategoryTree {

    @SerializedName("root")
    @Expose
    private Root root;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("root", root).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(root).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CategoryTree) == false) {
            return false;
        }
        CategoryTree rhs = ((CategoryTree) other);
        return new EqualsBuilder().append(root, rhs.root).isEquals();
    }

}