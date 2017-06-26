package com.shijie.pojo.androidsdk.db;

import android.content.Context;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.db
 * 创建者:  zsj
 * 创建事件: 2017/5/15 10:01
 * 描述:
 */

public class RealmManager  {
    //SDK数据库名字
    private static final String DB_NAME = "vnandroidsdk.realm";

    private static Realm mRealm;

    public static Realm getRealm() {
        mRealm = Realm.getInstance(new RealmConfiguration
                .Builder()
                .name(DB_NAME) //指定数据库名字
                .build());
        return mRealm;
    }

    //负责初始化整个Relam数据库
    public static void init(Context context) {
        Realm.init(context);
        Log.e("realm", getRealm().getPath() + "XXX");
    }

    //关闭Realm数据库
    public static void closeRealm() {
        if (mRealm != null && !mRealm.isClosed()) {
            mRealm.close();
        }
    }

}
