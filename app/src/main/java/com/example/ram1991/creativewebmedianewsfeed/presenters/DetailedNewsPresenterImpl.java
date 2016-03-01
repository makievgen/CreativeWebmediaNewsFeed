package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.ui.views.DetailedNewsViewer;

public class DetailedNewsPresenterImpl implements DetailedNewsPresenter {
    DetailedNewsViewer detailedNewsViewer;

    public DetailedNewsPresenterImpl(DetailedNewsViewer detailedNewsViewer) {
        this.detailedNewsViewer = detailedNewsViewer;
    }

    @Override
    public void getURL() {
        detailedNewsViewer.showWebPage();
        // here we could take the URL from the DB, but it's only test app
    }
}
