package com.example.core.net.callback;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/9 下午5:36
 * - @Email whynightcode@gmail.com
 */
public interface IError {
    /**
     *
     * @param code
     * @param msg
     */
    void onError(int code,String msg);
}
