package com.cencosud.login.presentation.activity;

import com.cencosud.login.R;
import com.cencosud.login.presentation.fragment.WizardFragment;
import com.core.presentation.activity.BaseFragmentActivity;

public class WizardActivity extends BaseFragmentActivity {
    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void initView() {
        setFragment(new WizardFragment());
    }

    @Override
    protected void injectDependencies() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wizard;
    }

    @Override
    protected void trackScreen() {
    }
}
