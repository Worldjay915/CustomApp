package com.shijie.pojo.customapp.hybird;


import cn.pedant.SafeWebViewBridge.InjectedChromeClient;

/**
 * ChromeClient 必须自定义继承  InjectedChromeClient
 */
public class MyChromeClient extends InjectedChromeClient{
    public MyChromeClient(String injectedName, Class injectedCls) {
        super(injectedName, injectedCls);
    }
}
