package com.example.ram1991.creativewebmedianewsfeed.interactors;

import android.app.ListActivity;

import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NewsInteractorImpl extends ListActivity implements NewsInteractor, Callback<News> {
    NewsPresenter newsPresenter;
    private static final String BASE_URL = "http://timesofindia.indiatimes.com/";

    public NewsInteractorImpl(NewsPresenter newsPresenter) {
        this.newsPresenter = newsPresenter;
    }

    @Override
    public void sendRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IndiaNewsAPI indiaNewsAPI = retrofit.create(IndiaNewsAPI.class);
        Call<News> call = indiaNewsAPI.getListNews();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<News> call, Response<News> response) {
        if (response.isSuccess()) {
            newsPresenter.onNetworkSuccess(response);
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
