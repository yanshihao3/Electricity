package com.example.core.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/10 下午3:26
 * - @Email whynightcode@gmail.com
 */
public class BaseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
