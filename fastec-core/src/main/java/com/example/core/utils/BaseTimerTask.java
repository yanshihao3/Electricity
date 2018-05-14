package com.example.core.utils;

import java.util.TimerTask;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/10 下午4:24
 * - @Email whynightcode@gmail.com
 */
public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener ITimerListener) {
        mITimerListener = ITimerListener;
    }



    @Override
    public void run() {
        if (mITimerListener!=null){
            mITimerListener.onTimer();
        }
    }
}
