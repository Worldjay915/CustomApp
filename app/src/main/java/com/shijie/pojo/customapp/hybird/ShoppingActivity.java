package com.shijie.pojo.customapp.hybird;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.shijie.pojo.customapp.R;

public class ShoppingActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        myWebView = (WebView) findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new MyChromeClient("HostApp",HostApp.class));

        myWebView.loadUrl("file:///android_asset/index.html");

    }
}
