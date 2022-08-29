package com.app.cl.movies;

import static com.movies.frameworks.commonsv1.utlis.Constants.FILM_DETAIL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import com.movies.dashboard.filmDetail.ui.activity.FilmDetailActivity;
import com.movies.dashboard.films.ui.activity.HomeActivity;
import com.core.presentation.fragment.BaseFragment;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.movies.frameworks.commonsv1.App;
import com.movies.frameworks.commonsv1.Config;
import com.movies.frameworks.commonsv1.router.Provider;
import com.movies.frameworks.commonsv1.router.Router;
import com.movies.frameworks.commonsv1.router.Routes;

@SuppressWarnings("unchecked")
public class MoviesApplication extends App {

    @SuppressLint("ResourceType")
    @Override
    public void onCreate() {

        super.onCreate();
        if (BuildConfig.DEBUG) {
            FacebookSdk.setIsDebugEnabled(true);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        } else {
            FacebookSdk.setIsDebugEnabled(false);
        }

        Config.setBaseUrl(BuildConfig.baseUrl);

        Router.setProvider(new Provider() {
            @Override
            public BaseFragment getFragment(String id, Object... params) {
                return null;
            }

            @Override
            public Intent getActivityIntent(String id, Object[] params) {
                Context context = MoviesApplication.this;
                switch (id) {
                    case Routes.GO_TO_HOME:
                        return new Intent(context, HomeActivity.class);
                    case Routes.GO_TO_FILM_DETAIL:
                        Intent goToFilmDetailIntent = new Intent(context, FilmDetailActivity.class);
                        goToFilmDetailIntent.putExtra(FILM_DETAIL, (Parcelable) params[0]);
                        return goToFilmDetailIntent;
                    default:
                        return null;
                }
            }
        });
    }
}