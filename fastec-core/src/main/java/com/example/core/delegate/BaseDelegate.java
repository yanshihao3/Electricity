package com.example.core.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * @author yanshihao
 */
public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder mUnbinder = null;

    /**
     *
     * @return
     */
    public abstract Object setLayout();

    /**
     * @param savedInstanceState
     * @param viewRoot
     */
    public abstract void onBindView(@NonNull Bundle savedInstanceState, View viewRoot);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewroot = null;
        if (setLayout() instanceof Integer) {
            viewroot = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            viewroot = (View) setLayout();
        }
        if (viewroot != null) {
            mUnbinder = ButterKnife.bind(this, viewroot);
            onBindView(savedInstanceState, viewroot);
        }

        return viewroot;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
