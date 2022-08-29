package com.movies.dashboard.films.presentation.presenter;

import androidx.annotation.NonNull;

import com.core.domain.usecase.UseCaseObserver;
import com.movies.dashboard.films.presentation.contract.HomeContract;
import com.movies.frameworks.commonsv1.films.domain.model.FilmsList;
import com.movies.frameworks.commonsv1.films.domain.usecase.GetMoviesUseCase;
import com.movies.frameworks.commonsv1.utlis.Log;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    private final GetMoviesUseCase getMoviesUseCase;

    private HomeContract.HView mView;

    @Inject
    public HomePresenter(GetMoviesUseCase getMoviesUseCase) {
        this.getMoviesUseCase = getMoviesUseCase;
    }

    @Override
    public void initialize(HomeContract.HView view) {
        this.mView = view;
        this.getMovies("cb03b960");
    }

    @Override
    public void getMovies(String key) {
        mView.showProgress();
        mView.hideRecycler();
        getMoviesUseCase.execute(key, new UseCaseObserver<FilmsList>() {
            @Override
            public void onNext(@NonNull FilmsList filmsList) {
                super.onNext(filmsList);
                mView.setList(filmsList.items);
                mView.hideProgress();
                mView.showRecycler();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.hideProgress();
                mView.hideRecycler();
                Log.e("Home", "getMovies(): " + e.getMessage());
            }
        });
    }
}
