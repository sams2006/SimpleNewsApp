package com.tuwiq.simplenewsapp;

import java.util.ArrayList;
import java.util.List;

public class GeneratorList {
    public static List<NewsItem> generateList(int size) {

        ArrayList<NewsItem> list = new ArrayList<>(size) ;
        for (int i=0 ; i < size ; i++) {
            String title = "عنوان الخبر رقم :" + i ;
            String subTitle =  "عنوان الخبر الفرعي  رقم :" + i ;
            list.add(new NewsItem(title , subTitle)) ;
        }
        return list ;
    }
}
