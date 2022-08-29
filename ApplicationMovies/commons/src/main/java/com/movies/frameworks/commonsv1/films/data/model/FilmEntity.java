package com.movies.frameworks.commonsv1.films.data.model;

import java.util.List;

public class FilmEntity {
    public String id;
    public String title;
    public String fullTitle;
    public String year;
    public String releaseState;
    public String image;
    public String runtimeMins;
    public String runtimeStr;
    public String plot;
    public String contentRating;
    public String imDbRating;
    public String imDbRatingCount;
    public String metacriticRating;
    public String genres;
    public List<GenreEntity> genreList;
    public String directors;
    public List<DirectorEntity> directorList;
    public String stars;
    public List <StarEntity> starList;
}