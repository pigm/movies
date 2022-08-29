package com.movies.frameworks.commonsv1.films.data.repository.mapper;

import androidx.annotation.Nullable;

import com.core.data.repository.mapper.Mapper;
import com.movies.frameworks.commonsv1.films.data.model.FilmEntity;
import com.movies.frameworks.commonsv1.films.domain.model.Film;

import javax.inject.Inject;

public class FilmToListMapper extends Mapper<FilmEntity, Film> {

    @Inject
    public FilmToListMapper() {
    }

    @Nullable
    @Override
    public Film map(@Nullable FilmEntity value) {
        Film film = new Film();
        film.id = value.id;
        film.title = value.title;
        film.fullTitle = value.fullTitle;
        film.year = value.year;
        film.releaseState = value.releaseState;
        film.image = value.image;
        film.runtimeMins = value.runtimeMins;
        film.runtimeStr = value.runtimeStr;
        film.plot = value.plot;
        film.contentRating = value.contentRating;
        film.imDbRating = value.imDbRating;
        film.imDbRatingCount = value.imDbRatingCount;
        film.metacriticRating = value.metacriticRating;
        film.genres = value.genres;
        film.directors = value.directors;
        film.stars = value.stars;
        return film;
    }

    @Nullable
    @Override
    public FilmEntity reverseMap(@Nullable Film value) {
        throw new UnsupportedOperationException();
    }
}
