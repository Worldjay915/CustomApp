package com.shijie.pojo.customapp.jpush;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.shijie.pojo.androidsdk.activity.AdBrowserActivity;
import com.shijie.pojo.customapp.R;
import com.shijie.pojo.customapp.activity.base.BaseActivity;
import com.shijie.pojo.customapp.module.PushMessage;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.jpush
 * 创建者:  zsj
 * 创建事件: 2017/5/21 9:36
 * 描述:  显示推送的消息界面
 */

public class PushMessageActivity extends BaseActivity {

    /**
     * UI
     */
    private TextView mTypeView;
    private TextView mTypeValueView;
    private TextView mContentView;
    private TextView mContentValueView;

    /**
     * data
     */
    private PushMessage mPushMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpush_layout);
        initData();
        initView();
    }

    //初始化推送过来的数据
    private void initData() {
        Intent intent = getIntent();
        mPushMessage = (PushMessage) intent.getSerializableExtra("pushMessage");
    }

    private void initView() {
        mTypeView = (TextView) findViewById(R.id.message_type_view);
        mTypeValueView = (TextView) findViewById(R.id.message_type_value_view);
        mContentView = (TextView) findViewById(R.id.message_content_view);
        mContentValueView = (TextView) findViewById(R.id.message_content_value_view);

        mTypeValueView.setText(mPushMessage.messageType);
        mContentValueView.setText(mPushMessage.messageContent);
        if (!TextUtils.isEmpty(mPushMessage.messageUrl)) {
            //跳转到web页面
            gotoWebView();
        }
    }

    private void gotoWebView() {
        Intent intent = new Intent(this, AdBrowserActivity.class);
        intent.putExtra(AdBrowserActivity.KEY_URL, mPushMessage.messageUrl);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
