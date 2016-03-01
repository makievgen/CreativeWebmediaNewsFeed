package com.example.ram1991.creativewebmedianewsfeed.ui.views;

import android.os.Bundle;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;

import java.util.List;
import java.util.Map;

import retrofit2.Response;

public interface NewsViewer {
    void showError();

    void showDetailedInfo(Bundle bundle);

    void setData(Response<News> response);

    void startRefresh();

    void showFeedNews(List<Map<String, String>> newsList);
}
