package com.example.ram1991.creativewebmedianewsfeed.interactors.apis;

import com.example.ram1991.creativewebmedianewsfeed.interactors.Constants;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            int count = response.body().getNewsItem().size();
            List<Map<String, String>> newsList = new ArrayList<>();
            Map<String, String> map;
            for (int i = 0; i < count; i++) {
                map = new HashMap<>();
                map.put(Constants.HEAD_LINE, response.body().getNewsItem().get(i).getHeadLine());
                map.put(Constants.DATE_LINE, response.body().getNewsItem().get(i).getDateLine());
                map.put(Constants.WEB_URL, response.body().getNewsItem().get(i).getWebURL());
                newsList.add(map);
            }
            mNewsPresenter.onNetworkSuccess(newsList);

        } else {
            mNewsPresenter.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<News> call, Throwable t) {
        mNewsPresenter.onNetworkFailure();
    }

}
