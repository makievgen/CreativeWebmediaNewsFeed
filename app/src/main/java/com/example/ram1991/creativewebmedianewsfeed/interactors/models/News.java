
package com.example.ram1991.creativewebmedianewsfeed.interactors.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class News {

    @SerializedName("Pagination")
    @Expose
    private com.example.ram1991.creativewebmedianewsfeed.interactors.models.Pagination Pagination;
    @SerializedName("NewsItem")
    @Expose
    private List<com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsItem> NewsItem = new ArrayList<com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsItem>();

    /**
     * 
     * @return
     *     The Pagination
     */
    public com.example.ram1991.creativewebmedianewsfeed.interactors.models.Pagination getPagination() {
        return Pagination;
    }

    /**
     * 
     * @param Pagination
     *     The Pagination
     */
    public void setPagination(com.example.ram1991.creativewebmedianewsfeed.interactors.models.Pagination Pagination) {
        this.Pagination = Pagination;
    }

    /**
     * 
     * @return
     *     The NewsItem
     */
    public List<com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsItem> getNewsItem() {
        return NewsItem;
    }

    /**
     * 
     * @param NewsItem
     *     The NewsItem
     */
    public void setNewsItem(List<com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsItem> NewsItem) {
        this.NewsItem = NewsItem;
    }

}
