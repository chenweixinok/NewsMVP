package com.example.lenovo.newsmvp.main.presenter.impl;


import com.example.lenovo.newsmvp.R;
import com.example.lenovo.newsmvp.main.presenter.MainPresenter;
import com.example.lenovo.newsmvp.main.view.MainView;
import com.example.lenovo.newsmvp.main.view.widget.MainActivity;

public class MainPresenterImpl implements MainPresenter{

    MainView mMainView;

    public MainPresenterImpl(MainActivity mMainView){
        this.mMainView = mMainView;
    }

    @Override
    public void switchNavigation(int id) {

        if (id == R.id.navigation_item_about) {
            mMainView.switch2About();
        } else if (id == R.id.navigation_item_news) {
            mMainView.switch2News();
        }

    }
}