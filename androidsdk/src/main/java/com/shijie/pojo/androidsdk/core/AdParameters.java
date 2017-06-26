package com.shijie.pojo.androidsdk.core;

import com.shijie.pojo.androidsdk.constant.SDKConstant;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.core
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:32
 * 描述: 广告SDK全局参数配置, 都用静态来保证统一性
 */

public class AdParameters {

    //用来记录可自动播放的条件
    private static SDKConstant.AutoPlaySetting currentSetting = SDKConstant.AutoPlaySetting.AUTO_PLAY_3G_4G_WIFI; //默认都可以自动播放

    public static void setCurrentSetting(SDKConstant.AutoPlaySetting setting) {
        currentSetting = setting;
    }

    public static SDKConstant.AutoPlaySetting getCurrentSetting() {
        return currentSetting;
    }

    /**
     * 获取sdk当前版本号
     */
    public static String getAdSDKVersion() {
        return "1.0.0";
    }

}
