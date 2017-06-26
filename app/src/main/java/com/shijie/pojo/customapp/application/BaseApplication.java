package com.shijie.pojo.customapp.application;

import android.app.Application;

import com.shijie.pojo.customapp.share.ShareManager;

import cn.jpush.android.api.JPushInterface;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.application
 * 创建者:  zsj
 * 创建事件: 2017/5/11 10:35
 * 描述:  程序入口
 */

public class BaseApplication extends Application {

    private static BaseApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initShareSDK();
        initJPush();
    }

    public static BaseApplication getInstance(){
        return  mApplication;
    }

    public void initShareSDK() {
        ShareManager.initSDK(this);
    }

    private void initJPush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }




}
