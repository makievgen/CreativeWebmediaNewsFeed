package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.interactors.NewsInteractor;
import com.example.ram1991.creativewebmedianewsfeed.interactors.NewsInteractorImpl;
import com.example.ram1991.creativewebmedianewsfeed.views.NewsViewer;

import java.util.List;
import java.util.Map;

public class NewsPresenterImpl implements NewsPresenter {
    NewsViewer newsViewer;
    NewsInteractor newsInteractorImpl;

    public NewsPresenterImpl(NewsViewer newsViewer) {
        this.newsViewer = newsViewer;
        newsInteractorImpl = new NewsInteractorImpl(this);
    }

    @Override
    public void sendRequest() {
        newsInteractorImpl.sendRequest();
    }

    @Override
    public void onNetworkSuccess(List<Map<String, String>> newsList) {
        newsViewer.showFeedNews(newsList);
    }

    @Override
    public void onNetworkFailure() {
        newsViewer.showError();
    }

}
