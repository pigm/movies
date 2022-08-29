package com.movies.frameworks.commonsv1.films.data.repository;

import com.movies.frameworks.commonsv1.films.data.remote.MoviesApi;
import com.movies.frameworks.commonsv1.films.data.repository.mapper.FilmsToDomainMapper;
import com.movies.frameworks.commonsv1.films.domain.model.FilmsList;
import com.movies.frameworks.commonsv1.films.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MoviesRepositoryImpl implements MoviesRepository {

    private final MoviesApi api;
    private final FilmsToDomainMapper mapper;

    @Inject
    public MoviesRepositoryImpl(MoviesApi api, FilmsToDomainMapper mapper) {
        this.api = api;
        this.mapper = mapper;
    }

    @Override
    public Observable<FilmsList> getMovies(String key) {
        return api.getMovies(
                key
        ).map(response -> {
            if (response.errorMessage != null && !response.errorMessage.equals("")) {
                throw new Exception("Error: " + response.errorMessage);
            }
            return mapper.map(response);
        });
    }
}
