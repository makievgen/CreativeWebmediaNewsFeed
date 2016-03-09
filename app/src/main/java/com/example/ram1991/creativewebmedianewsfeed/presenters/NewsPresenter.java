package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsListItem;

import java.util.List;

public interface NewsPresenter {
    void sendRequest();

    void onNetworkSuccess(List<NewsListItem> newsList);

    void onNetworkFailure();
}
