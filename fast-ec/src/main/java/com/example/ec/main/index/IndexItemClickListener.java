package com.example.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.example.core.delegate.LatteDelegate;
import com.example.ec.main.detail.GoogsDetailDelegate;
import com.example.core.ui.recycer.MultipleFields;
import com.example.core.ui.recycer.MultipleItem;

/**
 */

public class IndexItemClickListener extends SimpleClickListener {

    private final LatteDelegate DELEGATE;

    private IndexItemClickListener(LatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    public static SimpleClickListener create(LatteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final MultipleItem entity = (MultipleItem) baseQuickAdapter.getData().get(position);
        final int goodsId = entity.getField(MultipleFields.ID);
        final GoogsDetailDelegate delegate = new GoogsDetailDelegate();
        DELEGATE.getSupportDelegate().start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
    }
}
