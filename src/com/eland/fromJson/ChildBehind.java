package com.eland.fromJson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ChildBehind {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("doc_num")
    @Expose
    private Integer docNum;
    @SerializedName("child")
    @Expose
    private List<ChildBehindAgain> child = null;

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

    public List<ChildBehindAgain> getChild() {
        return child;
    }

    public void setChild(List<ChildBehindAgain> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("path", path).append("docNum", docNum).append("child", child).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(child).append(docNum).append(name).append(path).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChildBehind) == false) {
            return false;
        }
        ChildBehind rhs = ((ChildBehind) other);
        return new EqualsBuilder().append(child, rhs.child).append(docNum, rhs.docNum).append(name, rhs.name).append(path, rhs.path).isEquals();
    }

}