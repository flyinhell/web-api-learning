package com.eland.fromJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ResultList {

    @SerializedName("$p_type_2$")
    @Expose
    private String $pType2$;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("main_id")
    @Expose
    private String mainId;
    @SerializedName("p_type")
    @Expose
    private String pType;
    @SerializedName("page_url")
    @Expose
    private String pageUrl;
    @SerializedName("post_time")
    @Expose
    private String postTime;
    @SerializedName("s_area_id")
    @Expose
    private String sAreaId;
    @SerializedName("source_author")
    @Expose
    private String sourceAuthor;
    @SerializedName("title")
    @Expose
    private String title;

    public String get$pType2$() {
        return $pType2$;
    }

    public void set$pType2$(String $pType2$) {
        this.$pType2$ = $pType2$;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getSAreaId() {
        return sAreaId;
    }

    public void setSAreaId(String sAreaId) {
        this.sAreaId = sAreaId;
    }

    public String getSourceAuthor() {
        return sourceAuthor;
    }

    public void setSourceAuthor(String sourceAuthor) {
        this.sourceAuthor = sourceAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("$pType2$", $pType2$).append("id", id).append("mainId", mainId).append("pType", pType).append("pageUrl", pageUrl).append("postTime", postTime).append("sAreaId", sAreaId).append("sourceAuthor", sourceAuthor).append("title", title).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(title).append(pageUrl).append(mainId).append($pType2$).append(sourceAuthor).append(pType).append(sAreaId).append(postTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResultList) == false) {
            return false;
        }
        ResultList rhs = ((ResultList) other);
        return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title).append(pageUrl, rhs.pageUrl).append(mainId, rhs.mainId).append($pType2$, rhs.$pType2$).append(sourceAuthor, rhs.sourceAuthor).append(pType, rhs.pType).append(sAreaId, rhs.sAreaId).append(postTime, rhs.postTime).isEquals();
    }

}