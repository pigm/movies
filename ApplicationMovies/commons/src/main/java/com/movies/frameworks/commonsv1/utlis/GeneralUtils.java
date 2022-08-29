package com.movies.frameworks.commonsv1.utlis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

import com.movies.frameworks.commonsv1.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.UUID;

public final class GeneralUtils {
    private static final Locale locale = new Locale("es", "CL");
    public static int ITEMS_PER_PAGE = 20;
    private static String deviceId = null;
    private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";
    public boolean isVisibleModalPrime;
    private static GeneralUtils instance;

    public static GeneralUtils getInstance() {
        if (instance == null) {
            instance = new GeneralUtils();
        }
        return instance;
    }

    public static void tintImageView(ImageView imageView, @ColorRes int color) {
        tintImageView(imageView.getResources().getColor(color), imageView);
    }

    public static void tintImageView(@ColorInt int color, ImageView imageView) {
        imageView.setColorFilter(color);
    }

    public static @Nullable
    Drawable getButtonThemeBackground(@Nullable Activity activity, @StyleRes int theme) {
        if (activity == null) {
            return null;
        }

        TypedArray a = getButtonStyledAttrs(activity, theme);
        Drawable resp = getButtonBack(a);
        a.recycle();

        return resp;
    }

    public static void setButtonTheme(
            @Nullable Activity activity, @StyleRes int theme, @NonNull TextView button
    ) {
        if (activity == null) {
            return;
        }

        TypedArray a = getButtonStyledAttrs(activity, theme);
        button.setBackground(getButtonBack(a));
        button.setTextColor(a.getColor(R.styleable.ButtonTheme_android_textColor, 0));
        a.recycle();
    }

    private static TypedArray getButtonStyledAttrs(Activity activity, @StyleRes int theme) {
        return activity.getTheme().obtainStyledAttributes(theme, R.styleable.ButtonTheme);
    }

    private static @Nullable
    Drawable getButtonBack(TypedArray styledAttrs) {
        GradientDrawable drawable = (GradientDrawable) styledAttrs.getDrawable(R.styleable.ButtonTheme_android_background);

        if (drawable != null) {
            drawable.setColor(styledAttrs.getColor(R.styleable.ButtonTheme_backColor, 0));
            int strokeColor = styledAttrs.getColor(R.styleable.ButtonTheme_borderColor, 0);
            int strokeWith = styledAttrs.getDimensionPixelSize(R.styleable.ButtonTheme_borderWidth, 0);

            if (strokeColor != 0 && strokeWith != 0) {
                drawable.setStroke(strokeWith, strokeColor);
            }
        }

        return drawable;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    public static String UniqueIdDevice(Context context) {
        if (deviceId == null) {
            SharedPreferences sharedPrefs = context.getSharedPreferences(
                    PREF_UNIQUE_ID, context.MODE_PRIVATE);
            deviceId = sharedPrefs.getString(PREF_UNIQUE_ID, null);
            if (deviceId == null) {
                deviceId = UUID.randomUUID().toString();
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString(PREF_UNIQUE_ID, deviceId);
                editor.apply();
            }
        }
        return deviceId;
    }

    public static int dpToPx(Context context, int dps) {
        return context == null ? 0 : Math.round(context.getResources().getDisplayMetrics().density * dps);
    }
}
