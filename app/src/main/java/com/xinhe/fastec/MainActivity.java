package com.xinhe.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.core.activity.ProxyActivity;
import com.example.core.app.ConfigType;
import com.example.core.app.Latte;
import com.example.core.delegate.LatteDelegate;
import com.example.core.ui.launcher.ILauncherListener;
import com.example.core.ui.launcher.OnLauncherFinishTag;
import com.example.ec.main.index.EcBottomDelegate;
import com.example.ec.main.index.IndexDelegate;
import com.example.ec.sign.ISignListener;

import qiu.niorgai.StatusBarCompat;

/**
 * @author yanshihao
 */
public class MainActivity extends ProxyActivity implements
        ISignListener
,ILauncherListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
        StatusBarCompat.translucentStatusBar(this, true);

    }
    @Override
    public LatteDelegate setRootDelegate() {
        Latte.getConfigurations().put(ConfigType.ACTIVITY.name(),this);
        return new EcBottomDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this, "登录过", Toast.LENGTH_SHORT).show();
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "没有登录过", Toast.LENGTH_SHORT).show();
                startWithPop(new IndexDelegate());
                break;
        }
    }
}
