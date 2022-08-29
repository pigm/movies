package com.movies.frameworks.commonsv1.films.domain.usecase;

import androidx.annotation.NonNull;

import com.core.domain.usecase.UseCaseParam;
import com.movies.frameworks.commonsv1.films.domain.model.FilmsList;
import com.movies.frameworks.commonsv1.films.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetMoviesUseCase extends UseCaseParam<FilmsList, String> {
    private final MoviesRepository repository;

    @Inject
    public GetMoviesUseCase(MoviesRepository repository) {
        this.repository = repository;
    }
    @Override
    protected Observable<FilmsList> createObservableUseCase(@NonNull String key) {
        return repository.getMovies(key);
    }
}
