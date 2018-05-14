package com.example.core.ui.launcher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/10 下午5:59
 * - @Email whynightcode@gmail.com
 */
public class LauncherHolder implements Holder<Integer> {
    private AppCompatImageView imageView;


    @Override
    public View createView(Context context) {
        imageView=new AppCompatImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        imageView.setImageResource(data);

    }
}
