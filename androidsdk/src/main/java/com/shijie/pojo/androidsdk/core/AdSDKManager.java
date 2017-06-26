package com.shijie.pojo.androidsdk.core;

import android.content.Context;
import android.view.ViewGroup;

import com.shijie.pojo.androidsdk.core.display.DisplayAdContext;
import com.shijie.pojo.androidsdk.db.RealmManager;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.core
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:49
 * 描述:  用来为调用者创建所有支持类型的广告
 */

public class AdSDKManager {

    //SDK全局Context
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        //初始化SDK的时候，初始化Realm数据库
        RealmManager.init(mContext);
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 创建开机图广告
     *
     * @param parentContainer
     * @param appListener
     */
    public static void createDisplayAd(ViewGroup parentContainer, DisplayAdContext.DisplayAdAppListener appListener) {
        DisplayAdContext adContext = new DisplayAdContext(parentContainer);
        adContext.setAdAppListener(appListener);
    }

}
