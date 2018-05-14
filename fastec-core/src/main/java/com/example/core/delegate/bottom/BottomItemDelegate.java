package com.example.core.delegate.bottom;

import android.widget.Toast;

import com.example.core.R;
import com.example.core.app.Latte;
import com.example.core.delegate.LatteDelegate;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/11 下午5:52
 * - @Email whynightcode@gmail.com
 */
public abstract class BottomItemDelegate extends LatteDelegate {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
