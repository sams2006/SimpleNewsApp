package com.tuwiq.simplenewsapp;

public class NewsItem {
   private String title ;
   private String subTitle ;

    public NewsItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
