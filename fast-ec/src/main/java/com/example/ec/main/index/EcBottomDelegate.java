package com.example.ec.main.index;

import android.graphics.Color;

import com.example.core.delegate.bottom.BaseBottomDeleage;
import com.example.core.delegate.bottom.BottomItemDelegate;
import com.example.core.delegate.bottom.BottomTabBean;
import com.example.core.delegate.bottom.ItemBuilder;

import java.util.LinkedHashMap;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/11 下午6:31
 * - @Email whynightcode@gmail.com
 */
public class EcBottomDelegate extends BaseBottomDeleage {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        LinkedHashMap<BottomTabBean, BottomItemDelegate>items=new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
