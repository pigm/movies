package com.core.presentation.adapter;

public interface OnItemClickListener<T> {
    void onItemClick(int adapterPosition, T item);
}