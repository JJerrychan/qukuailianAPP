package com.cq.xinyupintai;

import android.app.Application;
import android.content.Context;
import android.util.Log;

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
    }
}
