package com.shijie.pojo.customapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.shijie.pojo.androidsdk.constant.SDKConstant;
import com.shijie.pojo.androidsdk.core.AdParameters;
import com.shijie.pojo.customapp.R;
import com.shijie.pojo.customapp.db.SPManager;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.activity
 * 创建者:  zsj
 * 创建事件: 2017/5/19 17:02
 * 描述:   设置
 */

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * UI
     */
    private RelativeLayout mWifiLayout;
    private RelativeLayout mAlwayLayout;
    private RelativeLayout mNeverLayout;
    private CheckBox mWifiBox, mAlwayBox, mNeverBox;
    private ImageView mBackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_layout);

        initView();
    }

    private void initView() {
        mBackView = (ImageView) findViewById(R.id.back_view);
        mWifiLayout = (RelativeLayout) findViewById(R.id.wifi_layout);
        mWifiBox = (CheckBox) findViewById(R.id.wifi_check_box);
        mAlwayLayout = (RelativeLayout) findViewById(R.id.alway_layout);
        mAlwayBox = (CheckBox) findViewById(R.id.alway_check_box);
        mNeverLayout = (RelativeLayout) findViewById(R.id.close_layout);
        mNeverBox = (CheckBox) findViewById(R.id.close_check_box);

        mBackView.setOnClickListener(this);
        mWifiLayout.setOnClickListener(this);
        mAlwayLayout.setOnClickListener(this);
        mNeverLayout.setOnClickListener(this);

        int currentSetting = SPManager.getInstance().getInt(SPManager.VIDEO_PLAY_SETTING, 1);
        switch (currentSetting) {
            case 0:
                mAlwayBox.setBackgroundResource(R.drawable.setting_selected);
                mWifiBox.setBackgroundResource(0);
                mNeverBox.setBackgroundResource(0);
                break;
            case 1:
                mAlwayBox.setBackgroundResource(0);
                mWifiBox.setBackgroundResource(R.drawable.setting_selected);
                mNeverBox.setBackgroundResource(0);
                break;
            case 2:
                mAlwayBox.setBackgroundResource(0);
                mWifiBox.setBackgroundResource(0);
                mNeverBox.setBackgroundResource(R.drawable.setting_selected);
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.alway_layout:
                SPManager.getInstance().putInt(SPManager.VIDEO_PLAY_SETTING, 0);
                AdParameters.setCurrentSetting(SDKConstant.AutoPlaySetting.AUTO_PLAY_3G_4G_WIFI);
                mAlwayBox.setBackgroundResource(R.drawable.setting_selected);
                mWifiBox.setBackgroundResource(0);
                mNeverBox.setBackgroundResource(0);
                break;
            case R.id.close_layout:
                SPManager.getInstance().putInt(SPManager.VIDEO_PLAY_SETTING, 2);
                AdParameters.setCurrentSetting(SDKConstant.AutoPlaySetting.AUTO_PLAY_NEVER);
                mAlwayBox.setBackgroundResource(0);
                mWifiBox.setBackgroundResource(0);
                mNeverBox.setBackgroundResource(R.drawable.setting_selected);
                break;
            case R.id.wifi_layout:
                SPManager.getInstance().putInt(SPManager.VIDEO_PLAY_SETTING, 1);
                AdParameters.setCurrentSetting(SDKConstant.AutoPlaySetting.AUTO_PLAY_ONLY_WIFI);
                mAlwayBox.setBackgroundResource(0);
                mWifiBox.setBackgroundResource(R.drawable.setting_selected);
                mNeverBox.setBackgroundResource(0);
                break;
            case R.id.back_view:
                finish();
                break;

        }
    }

}
