package com.movies.frameworks.commonsv1.films.data.remote;

import com.movies.frameworks.commonsv1.films.data.model.FilmsListEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApi {
    @GET("movies.json")
    Observable<FilmsListEntity> getMovies(
            @Query("key") String key
    );
}
