package com.shenhe.mvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * @author 马山水
 * @date 2018/3/30
 * @desc TODO
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
