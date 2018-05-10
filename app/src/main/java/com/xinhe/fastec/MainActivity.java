package com.xinhe.fastec;

import com.example.core.activity.ProxyActivity;
import com.example.core.delegate.LatteDelegate;

/**
 * @author yanshihao
 */
public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new MainDelegate();
    }

}
