package com.xinhe.fastec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.core.delegate.LatteDelegate;

/**
 * - @Author:  $user$
 * - @Time:  $date$ $time$
 */
public class MainDelegate extends LatteDelegate {
    private static final String TAG = "MainDelegate";
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View viewRoot) {

    }
}
