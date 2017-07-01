package com.shijie.pojo.customapp.hybird;


import android.webkit.WebView;
import android.widget.Toast;

import cn.pedant.SafeWebViewBridge.JsCallback;

/**
 * Java 层暴露给 JS 层的方法
 */
public class HostApp {

    public static void toast(WebView view,String msg){

        Toast.makeText(view.getContext(),msg,Toast.LENGTH_SHORT).show();
    }


    //异步购买商品
    public static void buyBook(WebView view, final JsCallback jsCallback){

        TaskExecutor.scheduleTaskOnUiThread(50, new Runnable() {
            @Override
            public void run() {
                try {
                    jsCallback.apply("购买成功");
                } catch (JsCallback.JsCallbackException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
