package com.eland.fromJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ChildBehindAgain {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("doc_num")
    @Expose
    private Integer docNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("path", path).append("docNum", docNum).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(docNum).append(name).append(path).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChildBehindAgain) == false) {
            return false;
        }
        ChildBehindAgain rhs = ((ChildBehindAgain) other);
        return new EqualsBuilder().append(docNum, rhs.docNum).append(name, rhs.name).append(path, rhs.path).isEquals();
    }

}