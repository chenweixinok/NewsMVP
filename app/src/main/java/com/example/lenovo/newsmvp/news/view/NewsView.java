package com.example.lenovo.newsmvp.news.view;



import com.example.lenovo.newsmvp.beans.NewsBean;

import java.util.List;

/**
 * Created by Ruipeng Lu on 2016/2/22 0022.
 */
public interface NewsView {
    void showProgress();
    void showNews(List<NewsBean> newsList);
    void addNews(List<NewsBean> newsList);
    void hideProgress();
    void showLoadFailMsg();
}
