package com.example.core.ui.recycer;

import java.util.ArrayList;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/14 上午10:54
 * - @Email whynightcode@gmail.com
 */
public abstract class DataConverter {
    protected final ArrayList<MultipleItem> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItem> convert();

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }

    public void clearData(){
        ENTITIES.clear();
    }
}
