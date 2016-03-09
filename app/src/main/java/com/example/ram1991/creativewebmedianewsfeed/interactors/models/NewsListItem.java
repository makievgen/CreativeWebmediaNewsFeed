package com.example.ram1991.creativewebmedianewsfeed.interactors.models;

public class NewsListItem {

    private String head;
    private String date;
    private String url;

    public NewsListItem(String head, String date, String url) {
        this.head = head;
        this.date = date;
        this.url = url;
    }

    public String getHead() {
        return head;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
