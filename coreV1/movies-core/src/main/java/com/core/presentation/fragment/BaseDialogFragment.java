package com.core.presentation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import com.core.R;
import com.core.presentation.activity.BaseActivity;

public abstract class BaseDialogFragment<BINDER extends ViewDataBinding> extends DialogFragment {
    protected Context CONTEXT;
    protected BINDER binder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        injectDependencies();
    }

    protected abstract void injectDependencies();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        setRetainInstance(true);
        return binder.getRoot();
    }

    protected abstract int getLayoutId();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar mToolbar = view.findViewById(R.id.toolbar);
        if (mToolbar != null && getActivity() != null) {
            ((BaseActivity) getActivity()).setSupportActionBar(mToolbar);
        }
        initView();
    }

    protected abstract void initView();


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        CONTEXT = context;
    }

    public void startActivity(Class activityClass) {
        if (getActivity() != null) {
            Intent i = new Intent(getActivity(), activityClass);
            startActivity(i);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binder != null)
            binder.unbind();
    }

    public void finishActivity() {
        if (getActivity() != null)
            getActivity().finish();
    }


    protected void restartActivity() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).restartActivity();
        }
    }

    public void popBackStack() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog.getWindow() != null)
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}