package com.example.ec.icon;

import com.joanzapata.iconify.Icon;

public enum ECIcon implements Icon{

    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    char character;

    ECIcon(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
