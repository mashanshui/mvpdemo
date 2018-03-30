package com.shenhe.mvpdemo.present;

import com.shenhe.mvpdemo.data.LoginDataSource;
import com.shenhe.mvpdemo.data.LoginNetDataSource;
import com.shenhe.mvpdemo.ui.MainActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * @author 马山水
 * @date 2018/3/30
 * @desc TODO
 */
public class LoginPresent extends XPresent<MainActivity> {
    private LoginDataSource mLoginDataSource;

    public LoginPresent() {
        mLoginDataSource = new LoginNetDataSource();
    }

    public void login() {
        mLoginDataSource.login(getV().getUserName(), getV().getPassword(), new LoginDataSource.LoginCallBack() {
            @Override
            public void onSuccess(String userName, String passWord) {
                getV().toMainActivity(userName,passWord);
            }

            @Override
            public void onError() {
                getV().showFailedError();
            }
        });
    }
}
