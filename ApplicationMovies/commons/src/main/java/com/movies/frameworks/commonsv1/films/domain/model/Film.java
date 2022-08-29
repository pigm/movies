package com.movies.frameworks.commonsv1.films.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Film implements Parcelable {
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
    public List<Genre> genreList;
    public String directors;
    public List<Director> directorList;
    public String stars;
    public List<StarFilm> starList;

    public Film() {
    }

    protected Film(Parcel in) {
        id = in.readString();
        title = in.readString();
        fullTitle = in.readString();
        year = in.readString();
        releaseState = in.readString();
        image = in.readString();
        runtimeMins = in.readString();
        runtimeStr = in.readString();
        plot = in.readString();
        contentRating = in.readString();
        imDbRating = in.readString();
        imDbRatingCount = in.readString();
        metacriticRating = in.readString();
        genres = in.readString();
        directors = in.readString();
        stars = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(fullTitle);
        dest.writeString(year);
        dest.writeString(releaseState);
        dest.writeString(image);
        dest.writeString(runtimeMins);
        dest.writeString(runtimeStr);
        dest.writeString(plot);
        dest.writeString(contentRating);
        dest.writeString(imDbRating);
        dest.writeString(imDbRatingCount);
        dest.writeString(metacriticRating);
        dest.writeString(genres);
        dest.writeString(directors);
        dest.writeString(stars);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
