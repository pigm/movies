package com.movies.dashboard.films.ui.activity;

import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cencosud.login.R;
import com.cencosud.login.databinding.ActivityHomeBinding;
import com.core.presentation.activity.BaseFragmentActivity;
import com.movies.dashboard.films.domain.di.component.DaggerMoviesComponent;
import com.movies.dashboard.films.presentation.contract.HomeContract;
import com.movies.dashboard.films.presentation.presenter.HomePresenter;
import com.movies.dashboard.films.ui.adapter.HomeAdapter;
import com.movies.frameworks.commonsv1.films.domain.model.Film;
import com.movies.frameworks.commonsv1.router.Router;
import com.movies.frameworks.commonsv1.router.Routes;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseFragmentActivity<ActivityHomeBinding> implements
        HomeContract.HView{

    @Inject
    HomePresenter mPresenter;

    @Inject
    HomeAdapter adapter;

    @Override
    protected void initView() {
        this.mPresenter.initialize(this);
        this.setupView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void trackScreen() {
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public void showProgress() {
        binder.progressLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binder.progressLoading.setVisibility(View.GONE);
    }

    @Override
    public void showRecycler() {
        binder.listsRecycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRecycler() {
        binder.listsRecycler.setVisibility(View.GONE);
    }

    @Override
    protected void injectDependencies() {
        DaggerMoviesComponent.builder().build().inject(this);
    }

    private void setupView(){
        binder.toolbar.ivBack.setVisibility(View.GONE);
        binder.listsRecycler.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
        binder.listsRecycler.setAdapter(adapter);
        binder.listsRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter.setHomeListListener(new HomeAdapter.HomeAdapterListener() {
            @Override
            public void setOnListClick(int position) {
                goToDetail(position);
            }
        });
    }

    @Override
    public void setList(List<Film> films){
        adapter.setList(films);
    }

    private void goToDetail(int position){
        Router.redirect(HomeActivity.this, Routes.GO_TO_FILM_DETAIL,  adapter.getItem(position));
    }
}