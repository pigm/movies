package com.movies.frameworks.commonsv1.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.movies.frameworks.commonsv1.router.events.GoToWizardEvent;
import com.core.presentation.fragment.BaseFragment;
import com.core.presentation.fragment.BaseStackFragment;

public class Router {
    private static Provider provider;

    public static void setProvider(Provider provider) {
        Router.provider = provider;
    }

    public static Provider getProvider() {
        return provider;
    }

    private static Object getEvent(String eventString, Object data) {
        switch (eventString) {
            case Routes.GO_TO_WIZARD:
                return new GoToWizardEvent();
        }
        return null;
    }

    public static void redirect(BaseStackFragment stackFragment, String id, Object... params) {
        BaseFragment fragment = provider.getFragment(id, params);
        if (fragment != null)
            stackFragment.addFragmentToStack(fragment);
    }

    public static void redirect(Context context, String id, Object... params) {
        Intent intent = provider.getActivityIntent(id, params);
        if (intent != null)
            context.startActivity(intent);
    }

    public static void redirectActivityForResult(Context context, String id, int requestCode,
                                         Object... params) {
        Intent intent = provider.getActivityIntent(id, params);
        if (intent != null) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        }
    }

    public static void redirect(Context context, String id) {
        redirect(context, id, "");
    }

    public static void redirectAndClearPreviousActivites(Context context, String id, Object... params){
        Intent intent = provider.getActivityIntent(id, params);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("EXIT", true);
        context.startActivity(intent);
    }

}
