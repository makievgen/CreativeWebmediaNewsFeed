package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.interactors.apis.NewsInteractor;
import com.example.ram1991.creativewebmedianewsfeed.interactors.apis.NewsInteractorImpl;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsListItem;
import com.example.ram1991.creativewebmedianewsfeed.views.NewsViewer;

import java.util.List;

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
    public void onNetworkSuccess(List<NewsListItem> newsList) {
        mNewsViewer.showFeedNews(newsList);
    }

    @Override
    public void onNetworkFailure() {
        mNewsViewer.showError();
    }

}
