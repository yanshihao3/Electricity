package com.example.core.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.core.app.Latte;


/**
 * Created by 傅令杰 on 2017/4/2
 */

public final class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
