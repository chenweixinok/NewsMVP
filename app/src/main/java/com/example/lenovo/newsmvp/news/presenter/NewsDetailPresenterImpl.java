package com.example.lenovo.newsmvp.news.presenter;

import android.content.Context;

import com.example.lenovo.newsmvp.beans.NewsDetailBean;
import com.example.lenovo.newsmvp.commons.Urls;
import com.example.lenovo.newsmvp.news.model.NewsModel;
import com.example.lenovo.newsmvp.news.model.NewsModelImpl;
import com.example.lenovo.newsmvp.news.view.NewsDetailView;
import com.example.lenovo.newsmvp.news.view.NewsJsonUtils;
import com.example.lenovo.newsmvp.utils.OkHttpUtils;


/**
 * Created by Ruipeng Lu on 2016/2/23 0023.
 */
public class NewsDetailPresenterImpl implements NewsDetailPresenter{
    Context mContext;
    NewsDetailView mNewsDetailView;
    NewsModel mNewsModel;

    public NewsDetailPresenterImpl(Context mContext, NewsDetailView mNewsDetailView) {
        this.mContext = mContext;
        this.mNewsDetailView = mNewsDetailView;
        mNewsModel=new NewsModelImpl();
    }

    @Override
    public void loadNewsDetail(final String docId) {
        mNewsDetailView.showProgress();
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docId);
                if(newsDetailBean != null) {
                    mNewsDetailView.showNewsDetialContent(newsDetailBean.getBody());
                }
                mNewsDetailView.hideProgress();
            }

            @Override
            public void onFailure(Exception e) {
                mNewsDetailView.hideProgress();
            }
        };
        mNewsModel.loadNewsDetail(getDetailUrl(docId), loadNewsCallback);
    }

    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }
}
