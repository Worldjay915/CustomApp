package com.shijie.pojo.customapp.hybird;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.shijie.pojo.customapp.R;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.hybird
 * 创建者:  zsj
 * 创建事件: 2017/7/1 12:41
 * 描述:  关于软件 h5介绍
 */

public class AboutActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        myWebView = (WebView) findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.loadUrl("file:///android_asset/smallpage.html");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myWebView.destroy();
    }
}
