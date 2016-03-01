
package com.example.ram1991.creativewebmedianewsfeed.interactors.models;

import java.util.ArrayList;
import java.util.List;

public class News {

    private Pagination Pagination;

    private List<NewsItem> NewsItem = new ArrayList<>();

    public Pagination getPagination() {
        return Pagination;
    }

    public void setPagination(Pagination Pagination) {
        this.Pagination = Pagination;
    }

    public List<NewsItem> getNewsItem() {
        return NewsItem;
    }

    public void setNewsItem(List<NewsItem> NewsItem) {
        this.NewsItem = NewsItem;
    }

}
