package com.movies.dashboard.films.ui.adapter;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.cencosud.login.R;
import com.cencosud.login.databinding.ItemFilmBinding;
import com.core.presentation.adapter.BaseListAdapter;
import com.core.presentation.adapter.holder.BaseViewHolder;
import com.movies.frameworks.commonsv1.films.domain.model.Film;
import com.movies.frameworks.commonsv1.utlis.ResizeImage;

import javax.inject.Inject;

public class HomeAdapter extends BaseListAdapter<Film, HomeAdapter.ViewHolder> {

    private HomeAdapterListener listener;

    @Inject
    public HomeAdapter() {
    }

    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new ViewHolder(v);
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_film;
    }

    public class ViewHolder extends BaseViewHolder<Film, ItemFilmBinding> {
        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(view -> {
                if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    listener.setOnListClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void bind(int position, Film item) {
            super.bind(position, item);
            binder.titleText.setText(item.title);
            binder.dateText.setText(getString(R.string.premiere_text) + ": " + item.releaseState);
            binder.detailFilmText.setText(item.plot);
            if (item.image != null && !item.image.isEmpty()) {
                Glide.with(getContext())
                        .load(ResizeImage.resizeImage(item.image, ResizeImage.IMAGE_SIZE_SMALL))
                        .apply(new RequestOptions().placeholder(R.drawable.ic_empty_image)
                                .error(R.drawable.ic_empty_image))
                        .transition(withCrossFade(new DrawableCrossFadeFactory
                                .Builder().setCrossFadeEnabled(true).build()))
                        .into(binder.filmImage);
            }
        }
    }

    public void setHomeListListener(HomeAdapterListener listener) {
        this.listener = listener;
    }

    public interface HomeAdapterListener {
        void setOnListClick(int position);
    }
}
