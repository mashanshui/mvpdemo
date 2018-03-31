package com.shenhe.mvpdemo.data;

import android.util.Log;

import com.shenhe.mvpdemo.MyApplication;
import com.shenhe.mvpdemo.net.RetrofitService;

import cn.droidlover.xdroidmvp.base.ActivityCollector;
import cn.droidlover.xdroidmvp.net.HttpObserver;
import cn.droidlover.xdroidmvp.net.HttpRequestUtil;
import cn.droidlover.xdroidmvp.net.RetrofitConfig;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * @author 马山水
 * @date 2018/3/28
 * @desc TODO
 */
public class LoginNetDataSource implements LoginDataSource {
    private static final String TAG = "LoginNetDataSource";
    private RetrofitService retrofitService;

    @Override
    public void login(final String userName, final String passWord, final LoginCallBack callBack) {
//        //模拟子线程耗时操作
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //模拟登录成功
//                if ("zhy".equals(userName) && "123".equals(passWord)) {
//                    callBack.onSuccess(userName, passWord);
//                } else {
//                    callBack.onError();
//                }
//            }
//        }.start();
        retrofitService = HttpRequestUtil.getRetrofitClient(RetrofitService.class.getName());

        Observable<ResponseBody> observable= retrofitService.get();
        HttpObserver<ResponseBody> httpObserver=new HttpObserver<ResponseBody>(new HttpObserver.OnNextListener() {
            @Override
            public void onNext(Object o) {
                callBack.onSuccess(userName, passWord);
                Log.e(TAG, "onNext: " );
            }
        });
        RetrofitConfig.getInstance().statrPostTask(observable, httpObserver);
    }
}
