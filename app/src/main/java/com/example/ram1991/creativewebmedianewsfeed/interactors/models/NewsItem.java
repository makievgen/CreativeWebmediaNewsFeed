
package com.example.ram1991.creativewebmedianewsfeed.interactors.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("NewsItemId")
    @Expose
    private String NewsItemId;
    @SerializedName("HeadLine")
    @Expose
    private String HeadLine;
    @SerializedName("Agency")
    @Expose
    private String Agency;
    @SerializedName("DateLine")
    @Expose
    private String DateLine;
    @SerializedName("WebURL")
    @Expose
    private String WebURL;
    @SerializedName("Caption")
    @Expose
    private String Caption;
    @SerializedName("Keywords")
    @Expose
    private String Keywords;
    @SerializedName("Story")
    @Expose
    private String Story;
    @SerializedName("CommentCountUrl")
    @Expose
    private String CommentCountUrl;
    @SerializedName("CommentFeedUrl")
    @Expose
    private String CommentFeedUrl;
    @SerializedName("Related")
    @Expose
    private String Related;
    @SerializedName("ByLine")
    @Expose
    private String ByLine;

    /**
     * 
     * @return
     *     The NewsItemId
     */
    public String getNewsItemId() {
        return NewsItemId;
    }

    /**
     * 
     * @param NewsItemId
     *     The NewsItemId
     */
    public void setNewsItemId(String NewsItemId) {
        this.NewsItemId = NewsItemId;
    }

    /**
     * 
     * @return
     *     The HeadLine
     */
    public String getHeadLine() {
        return HeadLine;
    }

    /**
     * 
     * @param HeadLine
     *     The HeadLine
     */
    public void setHeadLine(String HeadLine) {
        this.HeadLine = HeadLine;
    }

    /**
     * 
     * @return
     *     The Agency
     */
    public String getAgency() {
        return Agency;
    }

    /**
     * 
     * @param Agency
     *     The Agency
     */
    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    /**
     * 
     * @return
     *     The DateLine
     */
    public String getDateLine() {
        return DateLine;
    }

    /**
     * 
     * @param DateLine
     *     The DateLine
     */
    public void setDateLine(String DateLine) {
        this.DateLine = DateLine;
    }

    /**
     * 
     * @return
     *     The WebURL
     */
    public String getWebURL() {
        return WebURL;
    }

    /**
     * 
     * @param WebURL
     *     The WebURL
     */
    public void setWebURL(String WebURL) {
        this.WebURL = WebURL;
    }

    /**
     * 
     * @return
     *     The Caption
     */
    public String getCaption() {
        return Caption;
    }

    /**
     * 
     * @param Caption
     *     The Caption
     */
    public void setCaption(String Caption) {
        this.Caption = Caption;
    }

    /**
     * 
     * @return
     *     The Keywords
     */
    public String getKeywords() {
        return Keywords;
    }

    /**
     * 
     * @param Keywords
     *     The Keywords
     */
    public void setKeywords(String Keywords) {
        this.Keywords = Keywords;
    }

    /**
     * 
     * @return
     *     The Story
     */
    public String getStory() {
        return Story;
    }

    /**
     * 
     * @param Story
     *     The Story
     */
    public void setStory(String Story) {
        this.Story = Story;
    }

    /**
     * 
     * @return
     *     The CommentCountUrl
     */
    public String getCommentCountUrl() {
        return CommentCountUrl;
    }

    /**
     * 
     * @param CommentCountUrl
     *     The CommentCountUrl
     */
    public void setCommentCountUrl(String CommentCountUrl) {
        this.CommentCountUrl = CommentCountUrl;
    }

    /**
     * 
     * @return
     *     The CommentFeedUrl
     */
    public String getCommentFeedUrl() {
        return CommentFeedUrl;
    }

    /**
     * 
     * @param CommentFeedUrl
     *     The CommentFeedUrl
     */
    public void setCommentFeedUrl(String CommentFeedUrl) {
        this.CommentFeedUrl = CommentFeedUrl;
    }

    /**
     * 
     * @return
     *     The Related
     */
    public String getRelated() {
        return Related;
    }

    /**
     * 
     * @param Related
     *     The Related
     */
    public void setRelated(String Related) {
        this.Related = Related;
    }

    /**
     * 
     * @return
     *     The ByLine
     */
    public String getByLine() {
        return ByLine;
    }

    /**
     * 
     * @param ByLine
     *     The ByLine
     */
    public void setByLine(String ByLine) {
        this.ByLine = ByLine;
    }

}
