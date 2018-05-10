package com.xinhe.fastec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.core.delegate.LatteDelegate;
import com.example.core.net.RestClient;
import com.example.core.net.callback.IError;
import com.example.core.net.callback.ISuccess;

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

        RestClient.builder().url("https://www.baidu.com/")
                .params("","")
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.e(TAG, "onError: " );
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSucces(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                }).build().get();
    }
}
