package com.movies.frameworks.commonsv1.films.domain.repository;

import com.movies.frameworks.commonsv1.films.domain.model.FilmsList;

import io.reactivex.Observable;

public interface MoviesRepository {
    Observable<FilmsList> getMovies(String key);
}
