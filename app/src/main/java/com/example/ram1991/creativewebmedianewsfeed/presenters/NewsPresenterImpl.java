package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.interactors.NewsInteractor;
import com.example.ram1991.creativewebmedianewsfeed.interactors.NewsInteractorImpl;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;
import com.example.ram1991.creativewebmedianewsfeed.ui.views.NewsViewer;

import retrofit2.Response;

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
    public void onNetworkSuccess(Response<News> response) {
        newsViewer.setData(response);
    }

    @Override
    public void onNetworkFailure() {
        newsViewer.showError();
    }

}
