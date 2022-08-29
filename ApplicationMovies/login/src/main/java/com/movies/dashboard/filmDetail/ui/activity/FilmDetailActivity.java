package com.movies.dashboard.filmDetail.ui.activity;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.movies.frameworks.commonsv1.utlis.Constants.FILM_DETAIL;

import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.cencosud.login.R;
import com.cencosud.login.databinding.ActivityFilmDetailBinding;
import com.core.presentation.activity.BaseFragmentActivity;
import com.movies.frameworks.commonsv1.films.domain.model.Film;
import com.movies.frameworks.commonsv1.utlis.ResizeImage;

public class FilmDetailActivity extends BaseFragmentActivity<ActivityFilmDetailBinding> {

    private Film film;

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    protected void initView() {
        film = getIntent().getParcelableExtra(FILM_DETAIL);
        setup();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_film_detail;
    }

    @Override
    protected void trackScreen() {

    }

    private void setup(){
        binder.includedToolbar.ivBack.setVisibility(View.VISIBLE);
        binder.includedToolbar.ivBack.setOnClickListener(v -> onBackPressed());
        binder.includedToolbar.textTitleDetail.setText(getString(R.string.film_text));
        if (film.image != null && !film.image.isEmpty()) {
            Glide.with(this)
                    .load(ResizeImage.resizeImage(film.image, ResizeImage.IMAGE_SIZE_LARGE))
                    .apply(new RequestOptions().placeholder(R.drawable.ic_empty_image)
                            .error(R.drawable.ic_empty_image))
                    .transition(withCrossFade(new DrawableCrossFadeFactory
                            .Builder().setCrossFadeEnabled(true).build()))
                    .into(binder.filmImage);
        }
        binder.titleText.setText(film.title);
        binder.plopText.setText(film.plot);
        binder.starsText.setText(film.stars);
        binder.directorsText.setText(film.directors);
        binder.premierText.setText(getString(R.string.premiere_text) + ": " + film.releaseState);
        binder.minText.setText(getString(R.string.duracion_text) + ": " + film.runtimeStr);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}