package com.xinhe.fastec;

import android.app.Application;

import com.example.core.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * @author yanshihao
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcons(new FontAwesomeModule())
                .withApiHost("https://www.baidu.com/")
                .configure();
    }
}