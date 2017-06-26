package com.shijie.pojo.androidsdk.core;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.core
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:47
 * 描述:
 */

public interface AdContextInterface {

    void onAdSuccess();

    void onAdFailed();

    void onClickVideo(String url);
}
