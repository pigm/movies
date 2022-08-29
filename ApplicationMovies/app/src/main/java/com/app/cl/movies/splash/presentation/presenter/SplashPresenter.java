package com.app.cl.movies.splash.presentation.presenter;

import com.app.cl.movies.splash.presentation.contract.SplashContract;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void initialize(SplashContract.View view) {
        this.mView = view;
    }
}
