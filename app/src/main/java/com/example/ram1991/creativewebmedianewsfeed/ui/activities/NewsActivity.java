package com.example.ram1991.creativewebmedianewsfeed.ui.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.News;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenterImpl;
import com.example.ram1991.creativewebmedianewsfeed.ui.adapters.NewsRecyclerAdapter;
import com.example.ram1991.creativewebmedianewsfeed.ui.fragments.FragmentInternetInfo;
import com.example.ram1991.creativewebmedianewsfeed.ui.views.NewsViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Response;

public class NewsActivity extends BaseActivity implements NewsViewer, FragmentInternetInfo.OnInternetInfoListener {
    NewsPresenter presenter;
    @Bind(R.id.rv_news)
    RecyclerView recyclerView;
    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;

    FragmentManager fm;
    LinearLayoutManager layoutManager;
    NewsRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        fm = getFragmentManager();
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Map<String, String>> dummyList = new ArrayList<>();
        adapter = new NewsRecyclerAdapter(this, dummyList);
        recyclerView.setAdapter(adapter);

        presenter = new NewsPresenterImpl(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startRefresh();
            }
        });
        this.startRefresh();

    }

    @Override
    public void startRefresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        presenter.sendRequest();
    }

    @Override
    public void showFeedNews(List<Map<String, String>> newsList) {
        adapter.setData(newsList);
    }

    @Override
    public void showError() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        FragmentInternetInfo dialogInternetInfo = new FragmentInternetInfo();
        fm.beginTransaction().add(0, dialogInternetInfo, FragmentInternetInfo.TAG).addToBackStack("FragmentInternetInfo_tag").commit();
    }

    @Override
    public void setData(Response<News> response) {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        int count = response.body().getNewsItem().size();
        List<Map<String, String>> newsList = new ArrayList<>();
        Map<String, String> map;
        for (int i = 0; i < count; i++) {
            map = new HashMap<>();
            map.put("headLine", response.body().getNewsItem().get(i).getHeadLine());
            map.put("dateLine", response.body().getNewsItem().get(i).getDateLine());
            map.put("WebURL", response.body().getNewsItem().get(i).getWebURL());
            newsList.add(map);
        }
        showFeedNews(newsList);
    }

    @Override
    public void showDetailedInfo(Bundle bundle) {
        Intent intent = new Intent(this, DetailedNewsActivity.class);
        intent.putExtra("WebURL", bundle);
        startActivity(intent);
    }

    @Override
    public void resetInternetConnected() {
        startRefresh();
    }
}
