package com.example.ram1991.creativewebmedianewsfeed.views;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsListItem;

import java.util.List;

public interface NewsViewer {
    void showError();

    void startRefresh();

    void showFeedNews(List<NewsListItem> newsList);
}
