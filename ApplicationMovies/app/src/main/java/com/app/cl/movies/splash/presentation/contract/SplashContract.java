package com.app.cl.movies.splash.presentation.contract;

import com.core.presentation.contract.BaseViewPresenter;

public interface SplashContract {
    interface View {
        void goToHome();
    }

    interface Presenter extends BaseViewPresenter<View> { }
}
