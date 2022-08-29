package com.cencosud.login.presentation.fragment;


import com.movies.frameworks.commonsv1.router.Router;
import com.movies.frameworks.commonsv1.router.Routes;
import com.cencosud.login.R;
import com.cencosud.login.databinding.FragmentWizardBinding;
import com.core.presentation.fragment.BaseStackFragment;

/**
 * Created by ana on 07-03-18.
 */

public class WizardFragment extends BaseStackFragment<FragmentWizardBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wizard;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void injectDependencies() {

    }


    @Override
    protected void trackScreen() {
    }

    @Override
    protected int getNavigationContainer() {
        return R.id.stackContainer;
    }

}
