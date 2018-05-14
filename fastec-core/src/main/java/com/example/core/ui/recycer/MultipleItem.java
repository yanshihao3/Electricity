package com.example.core.ui.recycer;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/14 上午10:54
 * - @Email whynightcode@gmail.com
 */
public class MultipleItem implements MultiItemEntity {

    private final ReferenceQueue<LinkedHashMap<Object,Object>> ITEM_QUEUE=new ReferenceQueue<>();

    private final LinkedHashMap<Object,Object> mLinkedHashMap=new LinkedHashMap<>();

    private final SoftReference<LinkedHashMap<Object,Object>>mSoftReference=new
            SoftReference<>(mLinkedHashMap,ITEM_QUEUE);

    public MultipleItem(LinkedHashMap<Object,Object>map) {
        mSoftReference.get().putAll(map);
    }

    public static MultipleEntityBuilder builder(){
        return new MultipleEntityBuilder();
    }
    @Override
    public int getItemType() {
        return (int) mSoftReference.get().get(MultipleFields.ITEM_TYPE);
    }


    @SuppressWarnings("unchecked")
    public final <T> T getField(Object key){
        return (T) mSoftReference.get().get(key);
    }

    public final LinkedHashMap<?,?> getFields(){
        return mSoftReference.get();
    }

    public final MultipleItem setField(Object key,Object value){
        mSoftReference.get().put(key,value);
        return this;
    }

    public static class MultipleEntityBuilder{
        private  LinkedHashMap<Object,Object>mWeakHashMap=new LinkedHashMap<>();
        public MultipleEntityBuilder(){
            mWeakHashMap.clear();
        }

        public MultipleEntityBuilder setItemType(int itemType) {
            mWeakHashMap.put(MultipleFields.ITEM_TYPE,itemType);
            return this;
        }


        public final MultipleEntityBuilder setField(Object key, Object value) {
            mWeakHashMap.put(key, value);
            return this;
        }

        public final MultipleEntityBuilder setFields(LinkedHashMap<?, ?> map) {
            mWeakHashMap.putAll(map);
            return this;
        }

        public final MultipleItem build() {
            return new MultipleItem(mWeakHashMap);
        }
    }
}
