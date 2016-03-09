package com.example.ram1991.creativewebmedianewsfeed.interactors.apis;

import com.example.ram1991.creativewebmedianewsfeed.interactors.Constants;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface IndiaNewsAPI {

    @GET("feeds/newsdefaultfeeds.cms?feedtype=sjson")
    Call<News> getListNews();

    class Factory {
        private static IndiaNewsAPI mService;

        public static IndiaNewsAPI getInstance() {
            if (mService == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                mService = retrofit.create(IndiaNewsAPI.class);
                return mService;
            }
            return mService;
        }
    }

}
