package com.example.ram1991.creativewebmedianewsfeed.views;

import java.util.List;
import java.util.Map;

public interface NewsViewer {
    void showError();

    void startRefresh();

    void showFeedNews(List<Map<String, String>> newsList);
}
