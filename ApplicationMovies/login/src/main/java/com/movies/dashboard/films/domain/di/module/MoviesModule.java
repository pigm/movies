package com.movies.dashboard.films.domain.di.module;

import android.content.Context;

import com.core.data.remote.ApiServiceFactory;
import com.movies.frameworks.commonsv1.App;
import com.movies.frameworks.commonsv1.Config;
import com.movies.frameworks.commonsv1.films.data.remote.MoviesApi;
import com.movies.frameworks.commonsv1.films.data.repository.MoviesRepositoryImpl;
import com.movies.frameworks.commonsv1.films.data.repository.mapper.FilmsToDomainMapper;
import com.movies.frameworks.commonsv1.films.domain.repository.MoviesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {
    @Provides
    Context provideContext() {
        return App.getInstance();
    }

    @Provides
    MoviesRepository moviesRepository(
            MoviesApi api,
            FilmsToDomainMapper mapper
    ) {
        return new MoviesRepositoryImpl(
                api,
                mapper
        );
    }

    @Provides
    @Singleton
    MoviesApi provideApi() {
        return ApiServiceFactory.build(MoviesApi.class, Config.getBaseUrl());
    }
}
