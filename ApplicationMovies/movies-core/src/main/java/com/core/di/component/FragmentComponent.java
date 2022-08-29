package com.core.di.component;

import androidx.fragment.app.Fragment;

public interface FragmentComponent<T extends Fragment>{
    void inject(T target);
}