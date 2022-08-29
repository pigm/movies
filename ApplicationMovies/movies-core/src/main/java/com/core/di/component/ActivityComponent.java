package com.core.di.component;

import android.app.Activity;

public interface ActivityComponent<T extends Activity>{
    void inject(T target);
}