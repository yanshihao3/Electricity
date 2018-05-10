package com.example.ec.icon;

import com.joanzapata.iconify.Icon;

public enum ECIcon implements Icon{

    fa_glass('\uf000'),
    fa_music('\uf001');

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
