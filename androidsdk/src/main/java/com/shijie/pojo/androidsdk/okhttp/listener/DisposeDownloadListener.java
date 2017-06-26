package com.shijie.pojo.androidsdk.okhttp.listener;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp.listener
 * 创建者:  zsj
 * 创建事件: 2017/5/10 16:45
 * 描述:   监听下载进度
 */

public interface DisposeDownloadListener extends DisposeDataListener {

    public void onProgress(int progrss);
}

