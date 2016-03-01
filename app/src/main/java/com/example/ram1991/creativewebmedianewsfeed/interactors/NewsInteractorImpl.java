package com.example.ram1991.creativewebmedianewsfeed.interactors;

import android.app.ListActivity;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.Constants;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NewsInteractorImpl extends ListActivity implements NewsInteractor, Callback<News> {
    NewsPresenter newsPresenter;

    public NewsInteractorImpl(NewsPresenter newsPresenter) {
        this.newsPresenter = newsPresenter;
    }

    @Override
    public void sendRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IndiaNewsAPI indiaNewsAPI = retrofit.create(IndiaNewsAPI.class);
        Call<News> call = indiaNewsAPI.getListNews();
        call.enqueue(this);

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
            newsPresenter.onNetworkSuccess(newsList);

        } else {
            newsPresenter.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<News> call, Throwable t) {
        newsPresenter.onNetworkFailure();
    }

    public interface IndiaNewsAPI {
        @GET("feeds/newsdefaultfeeds.cms?feedtype=sjson")
        Call<News> getListNews();
    }

}
