package com.core.presentation.adapter.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import java.util.Locale;

public abstract class BaseViewHolder<T,BINDER extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected final BINDER binder;

    public BaseViewHolder(View itemView) {
        super(itemView);
        binder= DataBindingUtil.getBinding(itemView);
    }

    public String getString(@StringRes int idString) {
        return itemView.getContext().getString(idString);
    }

    public int getColor(int idColor) {
        return getContext().getResources().getColor(idColor);
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public String getString(@StringRes int idString,String fillText) {
        return String.format(Locale.getDefault(),getString(idString),fillText);
    }


    public Drawable getVectorDrawable(int id) {
        return VectorDrawableCompat.create(getContext().getResources(), id, getContext().getTheme());
    }

    public Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    public void bind(int position, T item){}
}