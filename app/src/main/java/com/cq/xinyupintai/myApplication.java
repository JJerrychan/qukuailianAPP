package com.cq.xinyupintai;

import android.app.Application;
import android.content.Context;

import com.xuexiang.xhttp2.XHttpSDK;
import com.xuexiang.xui.XUI;

public class myApplication extends Application {

    private static Context mContext;
    //onCreate--->程序创建的时候执行
    @Override
    public void onCreate() {
        super.onCreate();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志
        mContext = getApplicationContext();
        XHttpSDK.init(this);   //初始化网络请求框架，必须首先执行
        XHttpSDK.debug("XHttp");  //需要调试的时候执行
        XHttpSDK.setBaseUrl("http://172.16.16.75:8080/");  //设置网络请求的基础地址
    }
}

