package com.shijie.pojo.androidsdk.core;

import android.content.Context;
import android.view.ViewGroup;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.core
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:54
 * 描述:  所有广告类型父类， 目前有開機图加轮播广告
 */

public class BaseRenderer {

    protected Context mContext;

    /**
     * UI
     */
    protected ViewGroup mParentView; //广告要加载到的父容器

    protected void initAdView() {
    }

    /**
     * 展示广告
     */
    public void onShow(String uri) {

    }

    /**
     * 销毁广告
     */
    public void onDispose() {
    }

}
