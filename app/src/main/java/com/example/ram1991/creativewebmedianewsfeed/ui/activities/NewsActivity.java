package com.example.ram1991.creativewebmedianewsfeed.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.Constants;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenterImpl;
import com.example.ram1991.creativewebmedianewsfeed.ui.adapters.NewsRecyclerAdapter;
import com.example.ram1991.creativewebmedianewsfeed.views.NewsViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsActivity extends BaseActivity implements NewsViewer, NewsRecyclerAdapter.OnNewsClickListener {
    NewsPresenter mPresenter;
    @Bind(R.id.rv_news)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.snackbarInternetInfo)
    View mCoordinatorLayoutView;

    private NewsRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Map<String, String>> dummyList = new ArrayList<>();
        mAdapter = new NewsRecyclerAdapter(this, dummyList);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = new NewsPresenterImpl(this);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startRefresh();
            }
        });
        this.startRefresh();
    }

    @Override
    public void startRefresh() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        mPresenter.sendRequest();
    }

    @Override
    public void showFeedNews(List<Map<String, String>> newsList) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        mAdapter.setData(newsList);
    }

    @Override
    public void showError() {
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 3000);

        Snackbar.make(mCoordinatorLayoutView, R.string.text_check_internet_connection, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onClick(String webUrl) {
        Intent intent = new Intent(this, DetailedNewsActivity.class);
        intent.putExtra(Constants.WEB_URL, webUrl);
        startActivity(intent);
    }
}
