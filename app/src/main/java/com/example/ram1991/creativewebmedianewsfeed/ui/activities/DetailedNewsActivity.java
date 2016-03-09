package com.example.ram1991.creativewebmedianewsfeed.ui.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.Constants;
import com.example.ram1991.creativewebmedianewsfeed.presenters.DetailedNewsPresenter;
import com.example.ram1991.creativewebmedianewsfeed.presenters.DetailedNewsPresenterImpl;
import com.example.ram1991.creativewebmedianewsfeed.views.DetailedNewsViewer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailedNewsActivity extends BaseActivity implements DetailedNewsViewer {
    private DetailedNewsPresenter mPresenter;
    @Bind(R.id.web_view)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);
        ButterKnife.bind(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mPresenter = new DetailedNewsPresenterImpl(this);
        startLoading();
    }

    @Override
    public void startLoading() {
        mPresenter.getURL();
    }

    @Override
    public void showWebPage() {
        String url = getIntent().getStringExtra(Constants.WEB_URL);
        if (url != null) {
            mWebView.loadUrl(url);
        }
    }
}
