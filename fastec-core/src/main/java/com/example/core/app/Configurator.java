package com.example.core.app;


import android.app.Activity;
import android.os.Handler;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * @author yanshihao
 */
public class Configurator {
    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();
    private static final Handler HANDLER = new Handler();

    /**
     * 静态内部类实现单例模式
     */
    private static class Holder {
        private final static Configurator sConfigurator = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.sConfigurator;
    }

    public HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
        LATTE_CONFIGS.put(ConfigType.HANDLER.name(), HANDLER);

    }

    /**
     * @param host
     * @return
     */
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public final Configurator withLoaderDelayed(long delayed) {
        LATTE_CONFIGS.put(ConfigType.LOADER_DELAYED.name(), delayed);
        return this;
    }

    /**
     *
     */
    private void checkConfigurations() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration not ready");
        }
    }

    /**
     * @param interceptor icon
     * @return
     */
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigType.INTERCEPTOR.name(), INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigType.INTERCEPTOR.name(), INTERCEPTORS);
        return this;
    }

    public final Configurator withIcons(IconFontDescriptor icon) {
        ICONS.add(icon);
        return this;
    }

    public final Configurator withWeChatAppId(String appId) {
        LATTE_CONFIGS.put(ConfigType.WE_CHAT_APP_ID.name(), appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String appSecret) {
        LATTE_CONFIGS.put(ConfigType.WE_CHAT_APP_SECRET.name(), appSecret);
        return this;
    }

    public final Configurator withActivity(Activity  activity) {
        LATTE_CONFIGS.put(ConfigType.ACTIVITY.name(), activity);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfigurations();
        return (T) LATTE_CONFIGS.get(key);
    }
}
