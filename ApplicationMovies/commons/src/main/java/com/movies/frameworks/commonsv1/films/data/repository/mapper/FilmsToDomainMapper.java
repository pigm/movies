package com.movies.frameworks.commonsv1.films.data.repository.mapper;

import androidx.annotation.Nullable;

import com.core.data.repository.mapper.Mapper;
import com.movies.frameworks.commonsv1.films.data.model.FilmsListEntity;
import com.movies.frameworks.commonsv1.films.domain.model.FilmsList;

import javax.inject.Inject;

public class FilmsToDomainMapper  extends Mapper<FilmsListEntity, FilmsList> {

    private final FilmToListMapper mapper;

    @Inject
    public FilmsToDomainMapper(FilmToListMapper mapper) {
        this.mapper = mapper;
    }

    @Nullable
    @Override
    public FilmsList map(@Nullable FilmsListEntity value) {
        FilmsList result = new FilmsList();
        result.items = mapper.map(value.items);
        result.errorMessage = value.errorMessage;

        return result;
    }

    @Nullable
    @Override
    public FilmsListEntity reverseMap(@Nullable FilmsList value) {
        throw new UnsupportedOperationException();
    }
}
