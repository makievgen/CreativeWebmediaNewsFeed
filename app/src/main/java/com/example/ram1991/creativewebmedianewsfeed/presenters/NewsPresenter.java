package com.example.ram1991.creativewebmedianewsfeed.presenters;

import java.util.List;
import java.util.Map;

public interface NewsPresenter {
    void sendRequest();

    void onNetworkSuccess(List<Map<String, String>> newsList);

    void onNetworkFailure();
}
