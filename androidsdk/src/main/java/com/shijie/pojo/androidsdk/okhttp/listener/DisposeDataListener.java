package com.shijie.pojo.androidsdk.okhttp.listener;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp.listener
 * 创建者:  zsj
 * 创建事件: 2017/5/9 19:56
 * 描述:  处理数据接口
 */

public interface DisposeDataListener {

    /**
     * 请求成功回调事件处理
     */
    public void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     */
    public void onFailure(Object reasonObj);



}
