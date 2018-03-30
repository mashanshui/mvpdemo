package com.shenhe.mvpdemo.view;

import com.shenhe.mvpdemo.present.LoginPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * @author 马山水
 * @date 2018/3/30
 * @desc TODO
 */
public interface LoginView extends IView<LoginPresent> {
    String getPassword();

    String getUserName();

    void toMainActivity(String userName,String password);

    void showFailedError();
}
