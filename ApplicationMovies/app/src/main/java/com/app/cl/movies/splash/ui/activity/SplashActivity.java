package com.app.cl.movies.splash.ui.activity;

import android.os.Handler;

import androidx.core.content.ContextCompat;

import com.app.cl.movies.R;
import com.app.cl.movies.databinding.ActivitySplashBinding;
import com.app.cl.movies.splash.domain.di.component.DaggerSplashComponent;
import com.app.cl.movies.splash.presentation.contract.SplashContract;
import com.app.cl.movies.splash.presentation.presenter.SplashPresenter;
import com.movies.frameworks.commonsv1.router.Router;
import com.movies.frameworks.commonsv1.router.Routes;
import com.core.presentation.activity.BaseSplashActivity;
import com.core.util.ConnectionUtils;
import com.core.util.DialogHelper;

import javax.inject.Inject;

public class SplashActivity extends BaseSplashActivity<ActivitySplashBinding> implements SplashContract.View {

    @Inject
    SplashPresenter mPresenter;


    @Override
    protected void openNextActivity() {
        mPresenter.initialize(SplashActivity.this);
        final Handler handler = new Handler();
        if (!isConnectionOff()) {
            try {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        goToHome();
                    }
                }, 5000);

            } catch (Exception e) {
                mPresenter.initialize(SplashActivity.this);
            }

        } else {
            if (!SplashActivity.this.isFinishing()) {
                new DialogHelper().attachContext(this).showConfirmationDialogCustom(
                        R.string.dialog_title_connection,
                        R.string.accept,
                        (dialog, which) -> {
                            dialog.dismiss();
                            openNextActivity();
                        },
                        ContextCompat.getColor(this, R.color.colorPrimary),
                        R.style.AlertDialogCustom,
                        true
                );
            }
        }
    }

    @Override
    public void injectDependencies() {
        DaggerSplashComponent.builder().build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void trackScreen() {
    }

    @Override
    protected int getSplashTime() {
        return 0;
    }

    @Override
    public void goToHome() {
        Router.redirect(this, Routes.GO_TO_HOME);
        finish();
    }

    public boolean isConnectionOff() {
        return ConnectionUtils.isConnectionOff(this);
    }
}
