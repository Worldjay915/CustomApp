package com.shijie.pojo.customapp.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shijie.pojo.customapp.R;
import com.shijie.pojo.customapp.activity.base.BaseActivity;
import com.shijie.pojo.customapp.view.fragment.home.HomeFragment;
import com.shijie.pojo.customapp.view.fragment.home.MineFragment;
import com.shijie.pojo.customapp.view.fragment.home.SmartFragment;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.activity
 * 创建者:  zsj
 * 创建事件: 2017/5/11 11:21
 * 描述:  创建首页所有的fragment 以及 fragment
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private android.app.FragmentManager fm;
    private HomeFragment mHomeFragment;
    private Fragment mCommonFragmentOne;
   // private MessageFragment mMessageFragment;
    private SmartFragment mSmartFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initView();
        //设置默认显示的fragment
        mHomeFragment =  new HomeFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,mHomeFragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.home_layout_view:
                //changeStatusBarColor(R.color.color_fed952);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mSmartFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    mCurrent = mHomeFragment;
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                //changeStatusBarColor(R.color.color_e3e3e3);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mSmartFragment == null) {
                    mSmartFragment = new SmartFragment();
                    fragmentTransaction.add(R.id.content_layout, mSmartFragment);
                } else {
                    mCurrent = mSmartFragment;
                    fragmentTransaction.show(mSmartFragment);
                }
                break;
            case R.id.mine_layout_view:
                //changeStatusBarColor(R.color.white);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mSmartFragment, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    mCurrent = mMineFragment;
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }

        fragmentTransaction.commit();
    }

    /**
     * 隐藏fragment
     * @param fragment
     * @param ft
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }
}
