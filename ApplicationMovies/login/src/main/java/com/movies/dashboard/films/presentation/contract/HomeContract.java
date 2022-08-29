package com.movies.dashboard.films.presentation.contract;

import com.core.presentation.contract.BaseViewPresenter;
import com.core.presentation.contract.IProgressView;
import com.movies.frameworks.commonsv1.films.domain.model.Film;

import java.util.List;

public interface HomeContract {

    interface HView extends IProgressView {
        void setList(List<Film> films);
    }

    interface Presenter extends BaseViewPresenter<HView> {
        void getMovies(String key);
    }
}

