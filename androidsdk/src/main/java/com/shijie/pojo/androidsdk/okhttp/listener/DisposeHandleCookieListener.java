package com.shijie.pojo.androidsdk.okhttp.listener;

import java.util.ArrayList;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp.listener
 * 创建者:  zsj
 * 创建事件: 2017/5/10 16:09
 * 描述:  当需要专门处理Cookie时创建此回调接口
 */

public interface DisposeHandleCookieListener {

    public void onCookie(ArrayList<String> cookieStrLists);

}
