package com.shijie.pojo.customapp.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.activity.base
 * 创建者:  zsj
 * 创建事件: 2017/5/11 11:21
 * 描述:  为继承的子类提供共的行为
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 输出日志所需要的TAG
     */
    public String TAG;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
