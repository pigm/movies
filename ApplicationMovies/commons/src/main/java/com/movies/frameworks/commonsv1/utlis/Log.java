package com.movies.frameworks.commonsv1.utlis;

import com.core.BuildConfig;

public class Log {
    public static void v(String tag, String message) {
        if (shouldPrint()) {
            android.util.Log.v(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (shouldPrint()) {
            android.util.Log.i(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (shouldPrint()) {
            android.util.Log.d(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (shouldPrint()) {
            android.util.Log.e(tag, message);
        }
    }

    private static boolean shouldPrint() {
        return BuildConfig.DEBUG;
    }
}
