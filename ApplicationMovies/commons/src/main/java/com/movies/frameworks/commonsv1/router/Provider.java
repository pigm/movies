package com.movies.frameworks.commonsv1.router;

import android.content.Intent;
import com.core.presentation.fragment.BaseFragment;

public interface Provider {
    BaseFragment getFragment(String id, Object... params);

    Intent getActivityIntent(String id, Object[] params);

}
