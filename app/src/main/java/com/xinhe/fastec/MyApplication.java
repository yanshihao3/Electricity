package com.xinhe.fastec;

import android.app.Application;

import com.example.core.app.Latte;
import com.example.ec.database.DatabaseManager;
import com.example.ec.icon.FontECModule;
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
                .withIcons(new FontECModule())
                .withApiHost("http://oxjde2kpq.bkt.clouddn.com/")
                .withLoaderDelayed(2000)
                .configure();
        DatabaseManager.getInstance().init(this);
    }
}