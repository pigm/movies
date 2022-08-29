package com.core.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.core.R;

import java.util.List;

public abstract class BaseActivity<BINDER extends ViewDataBinding> extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected BINDER binder;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(getMenuId(), menu);
        return true;
    }

    protected int getMenuId() {
        return R.menu.empty_menu;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTransitionAnimations();
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, getLayoutId());
        injectDependencies();
        setupToolbar();
        initView();
    }

    protected abstract void initView();

    protected void injectDependencies() {
    }


    protected abstract @LayoutRes
    int getLayoutId();

    @Override
    protected void onDestroy() {
        unbindViews();
        super.onDestroy();
    }

    protected void setupToolbar() {
        setupToolbar(R.id.toolbar);
    }

    protected void setupToolbar(int toolbarId) {
        mToolbar = findViewById(toolbarId);
        try {
            setSupportActionBar(mToolbar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startActivity(Class activityClass) {
        Intent i = new Intent(this, activityClass);
        startActivity(i);
    }

    private void unbindViews() {
        if (binder != null)
            binder.unbind();
    }

    protected void setTransitionAnimations() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    protected List<Fragment> getFragmentStack() {
        return getSupportFragmentManager().getFragments();
    }

    public void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    protected void showUpButton(boolean show) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(show);
    }

    protected void hideActionBar() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }

    protected abstract void trackScreen();

    @Override
    protected void onResume() {
        super.onResume();
        trackScreen();
    }
}