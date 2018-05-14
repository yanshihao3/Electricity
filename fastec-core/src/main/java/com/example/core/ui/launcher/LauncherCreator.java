package com.example.core.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/10 下午5:59
 * - @Email whynightcode@gmail.com
 */
public class LauncherCreator implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
