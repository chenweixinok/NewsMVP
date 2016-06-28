package com.example.lenovo.newsmvp.news.model;


import com.example.lenovo.newsmvp.utils.OkHttpUtils;

/**
 * Created by Ruipeng Lu on 2016/2/22 0022.
 */
public interface NewsModel {
    void loadNews(String url, OkHttpUtils.ResultCallback callback);
    void loadNewsDetail(String url, OkHttpUtils.ResultCallback callback);
}
