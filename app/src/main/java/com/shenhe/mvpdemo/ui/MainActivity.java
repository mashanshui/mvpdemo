package com.shenhe.mvpdemo.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shenhe.mvpdemo.R;
import com.shenhe.mvpdemo.present.LoginPresent;
import com.shenhe.mvpdemo.view.LoginView;

import cn.droidlover.xdroidmvp.mvp.XActivity;

public class MainActivity extends XActivity<LoginPresent> implements LoginView, View.OnClickListener {
    private Button btLogin;
    private TextInputEditText etUsername;
    private TextInputEditText etPassword;

    @Override
    public void initData(Bundle savedInstanceState) {
        btLogin = findViewById(R.id.bt_login);
        etPassword = findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_username);
        btLogin.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public LoginPresent newP() {
        return new LoginPresent();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public void toMainActivity(final String userName, final String password) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录成功：" + userName + password, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showFailedError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                getP().login();
                break;
            default:
                break;
        }
    }
}
