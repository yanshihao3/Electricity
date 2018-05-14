package com.example.core.app;


import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
* 工具类
* */
public class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static HashMap<String,Object> getConfigurations(){
        return getConfigurator().getLatteConfigs();
    }


    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
    public static Handler getHandler() {
        return (Handler) getConfigurations().get(ConfigType.HANDLER.name());
    }
}
