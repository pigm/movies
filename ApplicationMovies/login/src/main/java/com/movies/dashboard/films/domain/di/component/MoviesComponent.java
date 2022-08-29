package com.movies.dashboard.films.domain.di.component;

import com.movies.dashboard.films.ui.activity.HomeActivity;
import com.core.di.component.ActivityComponent;
import com.movies.dashboard.films.domain.di.module.MoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MoviesModule.class})
public interface MoviesComponent extends ActivityComponent<HomeActivity> {
}
