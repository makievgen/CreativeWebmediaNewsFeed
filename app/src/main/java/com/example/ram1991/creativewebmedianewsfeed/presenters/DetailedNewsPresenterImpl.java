package com.example.ram1991.creativewebmedianewsfeed.presenters;

import com.example.ram1991.creativewebmedianewsfeed.views.DetailedNewsViewer;

public class DetailedNewsPresenterImpl implements DetailedNewsPresenter {
    private DetailedNewsViewer mDetailedNewsViewer;

    public DetailedNewsPresenterImpl(DetailedNewsViewer detailedNewsViewer) {
        this.mDetailedNewsViewer = detailedNewsViewer;
    }

    @Override
    public void getURL() {
        mDetailedNewsViewer.showWebPage();
        // here we could take the URL from interactor DB, but it's only test app
    }
}
