package com.example.core.delegate.bottom;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/11 下午5:51
 * - @Email whynightcode@gmail.com
 */
public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
