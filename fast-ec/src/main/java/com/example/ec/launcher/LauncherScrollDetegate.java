package com.example.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.core.app.AccountManager;
import com.example.core.app.IUserChecker;
import com.example.core.delegate.LatteDelegate;
import com.example.core.ui.launcher.ILauncherListener;
import com.example.core.ui.launcher.LauncherCreator;
import com.example.core.ui.launcher.OnLauncherFinishTag;
import com.example.ec.R;

import java.util.ArrayList;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/10 下午5:52
 * - @Email whynightcode@gmail.com
 */
public class LauncherScrollDetegate extends LatteDelegate {

    private ArrayList<Integer> mList = new ArrayList<>();
    private ConvenientBanner<Integer> mConvenientBanner;
    private ILauncherListener mILauncherListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }
    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    private void initBnaner() {
        mList.add(R.mipmap.launcher_01);
        mList.add(R.mipmap.launcher_02);
        mList.add(R.mipmap.launcher_03);
        mList.add(R.mipmap.launcher_04);
        mList.add(R.mipmap.launcher_05);
        mConvenientBanner.setPages(new LauncherCreator(), mList);
        mConvenientBanner.setPageIndicator(new int[]{R.drawable.dot_focus, R.drawable.dot_normal})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        if (position == (mList.size() - 1)){
                            //检查用户是否登录
                            AccountManager.checkAccount(new IUserChecker() {
                                @Override
                                public void onSignIn() {
                                    mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                                }

                                @Override
                                public void onNotSignIn() {
                                    mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);

                                }
                            });

                        }
                    }
                })
                .setCanLoop(false);

    }

    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View viewRoot) {
        initBnaner();
    }
}
