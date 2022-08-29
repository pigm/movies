package com.core.presentation.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.databinding.ViewDataBinding;

import java.util.TimerTask;

public abstract class BaseSplashActivity<BINDER extends ViewDataBinding> extends BaseActivity<BINDER> {

    protected abstract void openNextActivity();

    @Override protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override public void injectDependencies() {}

    @Override public void initView() {
        hideActionBar();
        new Handler().postDelayed(new TimerTask() {
            @Override
            public void run() {
                openNextActivity();
            }
        }, getSplashTime());
    }

    protected abstract int getSplashTime();

    @Override protected void startActivity(Class activityClass) {
        finish();
        super.startActivity(activityClass);
    }
}