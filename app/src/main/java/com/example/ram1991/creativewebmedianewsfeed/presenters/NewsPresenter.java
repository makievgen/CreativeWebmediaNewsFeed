package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;

import retrofit2.Response;

public interface NewsPresenter {
    void sendRequest();

    void onNetworkSuccess(Response<News> response);

    void onNetworkFailure();
}
