package com.core.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class AndroidUtils {

    public static Boolean entryAddress = false;

    public static Boolean getEntryAddress() {
        return entryAddress;
    }

    public static void setEntryAddress(Boolean entryAddress) {
        AndroidUtils.entryAddress = entryAddress;
    }

    public static Boolean entryHome = false;

    public static Boolean getEntryHome() {
        return entryHome;
    }

    public static void setEntryHome(Boolean entryHome) {
        AndroidUtils.entryHome = entryHome;
    }


    public static void hideSoftKeyboard(Activity activity) {
        hideSoftKeyboard(activity.getCurrentFocus());
    }

    public static void hideSoftKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showSoftKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}