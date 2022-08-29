package com.app.cl.movies.splash.domain.di.component;

import com.app.cl.movies.splash.domain.di.module.SplashModule;
import com.app.cl.movies.splash.ui.activity.SplashActivity;
import com.core.di.component.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ana on 08-05-18.
 */
@Singleton
@Component(modules = {SplashModule.class})
public interface SplashComponent extends ActivityComponent<SplashActivity> {
}
