package com.shijie.pojo.customapp.share;

import cn.sharesdk.framework.Platform;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.share
 * 创建者:  zsj
 * 创建事件: 2017/5/20 10:12
 * 描述:  要分享的数据实体
 */

public class ShareData {
    /**
     * 要分享到的平台
     */
    public ShareManager.PlatofrmType mPlatformType;

    /**
     * 要分享到的平台的参数
     */
    public Platform.ShareParams mShareParams;


}
