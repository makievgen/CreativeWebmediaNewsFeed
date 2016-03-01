package com.example.ram1991.creativewebmedianewsfeed.ui.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.Constants;
import com.example.ram1991.creativewebmedianewsfeed.presenters.DetailedNewsPresenter;
import com.example.ram1991.creativewebmedianewsfeed.presenters.DetailedNewsPresenterImpl;
import com.example.ram1991.creativewebmedianewsfeed.views.DetailedNewsViewer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailedNewsActivity extends BaseActivity implements DetailedNewsViewer {
    DetailedNewsPresenter presenter;
    @Bind(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);
        ButterKnife.bind(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        presenter = new DetailedNewsPresenterImpl(this);
        startLoading();
    }

    @Override
    public void startLoading() {
        presenter.getURL();
    }

    @Override
    public void showWebPage() {
        Bundle bundle = getIntent().getBundleExtra(Constants.WEB_URL);
        if (getIntent().getBundleExtra(Constants.WEB_URL) != null){
            String url = bundle.getString(Constants.URL);
            webView.loadUrl(url);
        }
    }
}
