package com.core.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;

import com.core.R;

public class DialogHelper {
    protected Context context;
    protected AlertDialog dialog;

    public DialogHelper attachContext(Context context) {
        this.context = context;
        return this;
    }

    public void showMessageDialog(int idString) {
        showMessageDialog(context.getString(idString));
    }

    public void showMessageDialog(String text) {
        showMessageDialog(text, R.string.default_title);
    }

    public void showErrorDialog(int idString) {
        showErrorDialog(context.getString(idString));
    }

    public void showErrorDialog(String text) {
        showMessageDialog(text, R.string.ups);
    }

    public void showMessageDialog(String text, @StringRes int title) {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
            dialog = null;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            dialog = builder.setCancelable(false)
                    .setTitle(title)
                    .setMessage(text)
                    .setPositiveButton(R.string.ok, (dialog, which) -> dialog.cancel()).create();
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showConfirmationDialog(int title, int message, int positiveButtonTitle, int negativeButtonTitle, DialogInterface.OnClickListener positiveClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonTitle, positiveClickListener)
                .setNegativeButton(negativeButtonTitle, (dialogInterface, i) -> dialogInterface.dismiss()).create();
        dialog.show();
    }

    public void showConfirmationDialog(int message, int positiveButtonTitle, int negativeButtonTitle, DialogInterface.OnClickListener positiveClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.setCancelable(true)
                .setMessage(message)
                .setPositiveButton(positiveButtonTitle, positiveClickListener)
                .setNegativeButton(negativeButtonTitle, (dialogInterface, i) -> dialogInterface.dismiss()).create();

        dialog.show();
    }

    public void showConfirmationDialogCustom(int message,
                                             int positiveButtonTitle,
                                             int negativeButtonTitle,
                                             DialogInterface.OnClickListener positiveClickListener,
                                             DialogInterface.OnClickListener negativeClickListener,
                                             int colorPositive,
                                             int colorNegative,
                                             int style, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, style);
        final AlertDialog dialog = builder.setCancelable(cancelable)
                .setMessage(message)
                .setPositiveButton(positiveButtonTitle, positiveClickListener)
                .setNegativeButton(negativeButtonTitle, negativeClickListener).create();

        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(colorPositive);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(colorNegative);
    }

    public void showConfirmationDialogCustom(int message,
                                             int positiveButtonTitle,
                                             int negativeButtonTitle,
                                             DialogInterface.OnClickListener positiveClickListener,
                                             int colorPositive,
                                             int colorNegative,
                                             int style) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, style);
        final AlertDialog dialog = builder.setCancelable(true)
                .setMessage(message)
                .setPositiveButton(positiveButtonTitle, positiveClickListener)
                .setNegativeButton(negativeButtonTitle, (dialogInterface, i) -> dialogInterface.dismiss()).create();

        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(colorPositive);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(colorNegative);
    }

    public void showConfirmationDialogCustom(int message,
                                             int positiveButtonTitle,
                                             DialogInterface.OnClickListener positiveClickListener,
                                             int colorPositive,
                                             int style,
                                             boolean centerPositiveButton) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, style);
        final AlertDialog dialog = builder.setCancelable(true)
                .setMessage(message)
                .setPositiveButton(positiveButtonTitle, positiveClickListener)
                .create();

        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(colorPositive);
        if (centerPositiveButton) {
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
            positiveButtonLL.gravity = Gravity.CENTER_HORIZONTAL;
            positiveButtonLL.width = LinearLayout.LayoutParams.MATCH_PARENT;
            positiveButton.setLayoutParams(positiveButtonLL);
        }
    }
    public void showConfirmationDialogCustom(int message,
                                             int positiveButtonTitle,
                                             DialogInterface.OnClickListener positiveClickListener,
                                             int colorPositive,
                                             int style,
                                             boolean centerPositiveButton,
                                             boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, style);
        final AlertDialog dialog = builder.setCancelable(true)
                .setCancelable(cancelable)
                .setMessage(message)
                .setPositiveButton(positiveButtonTitle, positiveClickListener)
                .create();

        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(colorPositive);
        if (centerPositiveButton) {
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
            positiveButtonLL.gravity = Gravity.CENTER_HORIZONTAL;
            positiveButtonLL.width = LinearLayout.LayoutParams.MATCH_PARENT;
            positiveButton.setLayoutParams(positiveButtonLL);
        }
    }

    public void showConfirmationDialogCustom(int mMessage,
                                             int mPositiveButtonTitle,
                                             DialogInterface.OnClickListener mPositiveClickListener,
                                             int mColorPositive,
                                             int mStyle,
                                              int mLayout, boolean mCenterPositiveButton, boolean isSetView ) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context, mStyle);
        LayoutInflater mFactory = LayoutInflater.from(context);
        final View mTextEntryView = mFactory.inflate(mLayout, null);
        final AlertDialog mDialog = mBuilder.setCancelable(true)
                .setMessage(mMessage)
                .setPositiveButton(mPositiveButtonTitle, mPositiveClickListener)
                .setView(mTextEntryView)
                .create();
        mDialog.show();
        mDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(mColorPositive);
        if (mCenterPositiveButton) {
            Button mPositiveButton = mDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            LinearLayout.LayoutParams mPositiveButtonLL = (LinearLayout.LayoutParams) mPositiveButton.getLayoutParams();
            mPositiveButtonLL.gravity = Gravity.CENTER_HORIZONTAL;
            mPositiveButtonLL.width = LinearLayout.LayoutParams.MATCH_PARENT;
            mPositiveButton.setLayoutParams(mPositiveButtonLL);
        }
    }
}