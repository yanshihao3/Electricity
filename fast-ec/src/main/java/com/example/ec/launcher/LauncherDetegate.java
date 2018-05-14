package com.example.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.core.delegate.LatteDelegate;
import com.example.core.ui.launcher.ILauncherListener;
import com.example.core.utils.BaseTimerTask;
import com.example.core.utils.ITimerListener;
import com.example.core.utils.LattePreference;
import com.example.ec.R;
import com.example.ec.R2;
import com.example.ec.main.index.EcBottomDelegate;

import java.text.MessageFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/10 下午4:23
 * - @Email whynightcode@gmail.com
 */
public class LauncherDetegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.launcher_timetext)
    AppCompatTextView mTextView;

    private int mCount = 5;
    private ScheduledExecutorService mExecutorService;
    private ILauncherListener mILauncherListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    private void initTimer() {

        mExecutorService = new ScheduledThreadPoolExecutor(2);
        mExecutorService.scheduleWithFixedDelay(new BaseTimerTask(this), 0,
                1, TimeUnit.SECONDS);
    }


    @OnClick(R2.id.launcher_timetext)
    void onClick() {
        if (mExecutorService != null) {
            mExecutorService.shutdown();
            mExecutorService = null;
            checkIsShowScroll();
        }

    }

    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag("isFrist")) {
            startWithPop(new LauncherScrollDetegate());
        } else {
            startWithPop(new EcBottomDelegate());
            //检查用户是否登录
           /* AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                }

                @Override
                public void onNotSignIn() {
                    mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);

                }
            });
            startWithPop(new SignUpDeleate());*/
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View viewRoot) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(MessageFormat.format("跳过\n{0}s", mCount));
                mCount--;
                if (mCount < 0) {
                    if (mExecutorService != null) {
                        mExecutorService.shutdown();
                        mExecutorService = null;
                        checkIsShowScroll();
                    }
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mExecutorService != null) {
            mExecutorService.shutdown();
            mExecutorService = null;
        }
    }
}
