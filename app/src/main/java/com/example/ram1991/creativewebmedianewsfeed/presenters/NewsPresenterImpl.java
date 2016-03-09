package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.interactors.apis.NewsInteractor;
import com.example.ram1991.creativewebmedianewsfeed.interactors.apis.NewsInteractorImpl;
import com.example.ram1991.creativewebmedianewsfeed.views.NewsViewer;

import java.util.List;
import java.util.Map;

public class NewsPresenterImpl implements NewsPresenter {
    private NewsViewer mNewsViewer;
    private NewsInteractor mNewsInteractorImpl;

    public NewsPresenterImpl(NewsViewer newsViewer) {
        this.mNewsViewer = newsViewer;
        mNewsInteractorImpl = new NewsInteractorImpl(this);
    }

    @Override
    public void sendRequest() {
        mNewsInteractorImpl.sendRequest();
    }

    @Override
    public void onNetworkSuccess(List<Map<String, String>> newsList) {
        mNewsViewer.showFeedNews(newsList);
    }

    @Override
    public void onNetworkFailure() {
        mNewsViewer.showError();
    }

}
