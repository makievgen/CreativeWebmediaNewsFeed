
package com.example.ram1991.creativewebmedianewsfeed.interactors.models;

import java.util.ArrayList;
import java.util.List;

public class News {

    private Pagination Pagination;

    private List<NewsItem> NewsItem = new ArrayList<>();

    public List<NewsItem> getNewsItem() {
        return NewsItem;
    }


/*
    Unused mutators and accessors

    public Pagination getPagination() {
        return Pagination;
    }

    public void setPagination(Pagination Pagination) {
        this.Pagination = Pagination;
    }

    public void setNewsItem(List<NewsItem> NewsItem) {
        this.NewsItem = NewsItem;
    }
*/

}
