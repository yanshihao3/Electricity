package com.example.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.example.core.delegate.LatteDelegate;
import com.example.core.net.RestClient;
import com.example.core.net.callback.ISuccess;
import com.example.core.wechat.IWeChatSignInCallback;
import com.example.core.wechat.LatteWeChat;
import com.example.ec.R;
import com.example.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/11 下午12:17
 * - @Email whynightcode@gmail.com
 */
public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignListener mISignListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }


        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View viewRoot) {

    }

    @OnClick(R2.id.btn_sign_in)
    public void sign_in() {  //登录
        if (checkForm()) {
            RestClient.builder().url("")
                    .params("", "")
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            SignHandler.onSignIn(response, mISignListener);
                        }
                    }).build()
                    .post();
        }
    }

    @OnClick(R2.id.tv_link_sign_up)
    void sign_up() { //去注册

        startWithPop(new SignUpDeleate());
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void wechat()
    {
        LatteWeChat.getInstance().onSignSuccess(new IWeChatSignInCallback() {
            @Override
            public void onSignInSuccess(String userInfo) {

            }
        }).signIn();
    }
}
