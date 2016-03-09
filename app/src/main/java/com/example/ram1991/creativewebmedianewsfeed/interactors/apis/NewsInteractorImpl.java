package com.example.ram1991.creativewebmedianewsfeed.interactors.apis;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsItem;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsInteractorImpl implements NewsInteractor, Callback<News> {
    private NewsPresenter mNewsPresenter;

    public NewsInteractorImpl(NewsPresenter newsPresenter) {
        this.mNewsPresenter = newsPresenter;
    }

    @Override
    public void sendRequest() {
        IndiaNewsAPI.Factory.getInstance().getListNews().enqueue(this);
    }

    @Override
    public void onResponse(Call<News> call, Response<News> response) {
        if (response.isSuccess()) {

            List<NewsItem> list = response.body().getNewsItem();
            mNewsPresenter.onNetworkSuccess(list);

        } else {
            mNewsPresenter.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<News> call, Throwable t) {
        mNewsPresenter.onNetworkFailure();
    }

}
