package com.shijie.pojo.androidsdk.okhttp;

import com.shijie.pojo.androidsdk.module.AdInstance;
import com.shijie.pojo.androidsdk.okhttp.listener.DisposeDataHandle;
import com.shijie.pojo.androidsdk.okhttp.listener.DisposeDataListener;
import com.shijie.pojo.androidsdk.okhttp.request.CommonRequest;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:59
 * 描述:  sdk请求发送中心
 */

public class RequestCenter {

    /**
     * 发送广告请求
     */
    public static void sendImageAdRequest(String url, DisposeDataListener listener) {

        CommonOkHttpClient.post(CommonRequest.createPostRequest(url, null),
                new DisposeDataHandle(listener, AdInstance.class));
    }
}
