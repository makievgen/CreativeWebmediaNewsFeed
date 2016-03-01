package com.example.ram1991.creativewebmedianewsfeed.ui.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.Constants;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenter;
import com.example.ram1991.creativewebmedianewsfeed.presenters.NewsPresenterImpl;
import com.example.ram1991.creativewebmedianewsfeed.ui.OnNewsClickListener;
import com.example.ram1991.creativewebmedianewsfeed.ui.adapters.NewsRecyclerAdapter;
import com.example.ram1991.creativewebmedianewsfeed.views.NewsViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsActivity extends BaseActivity implements NewsViewer, OnNewsClickListener {
    NewsPresenter presenter;
    @Bind(R.id.rv_news)
    RecyclerView recyclerView;
    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.snackbarInternetInfo)
    View coordinatorLayoutView;

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
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        adapter.setData(newsList);
    }

    @Override
    public void showError() {
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 3000);

        Snackbar.make(coordinatorLayoutView, R.string.text_check_internet_connection, Snackbar.LENGTH_LONG)
                .setAction(R.string.button_text_ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // nothing happens
                    }
                })
                .show();
    }

    @Override
    public void onClick(Bundle bundle) {
        Intent intent = new Intent(this, DetailedNewsActivity.class);
        intent.putExtra(Constants.WEB_URL, bundle);
        //intent.putExtras(bundle);
        startActivity(intent);
    }
}
