package com.shijie.pojo.customapp.view.fragment.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shijie.pojo.androidsdk.okhttp.listener.DisposeDataListener;
import com.shijie.pojo.customapp.R;
import com.shijie.pojo.customapp.adapter.CourseAdapter;
import com.shijie.pojo.customapp.module.recommand.BaseRecommandModel;
import com.shijie.pojo.customapp.network.http.RequestCenter;
import com.shijie.pojo.customapp.view.fragment.BaseFragment;
import com.shijie.pojo.customapp.view.home.HomeHeaderLayout;
import com.shijie.pojo.customapp.zxing.app.CaptureActivity;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.view.fragment.home
 * 创建者:  zsj
 * 创建事件: 2017/5/11 10:37
 * 描述: 主界面
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final int REQUEST_QRCODE = 0x01;
    private static final String TAG ="customapp";
    /**
     * UI
     */
    private View mContentView;
    private ListView mListView;
    private TextView mQRCodeView; //二维码
    private TextView mCategoryView; //目录
    private TextView mSearchView;
    private ImageView mLoadingView;
    /**
     * data
     */
    private BaseRecommandModel mRecommandData;
    private CourseAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestRecommandData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();  //baseFragment 已经初始化
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initView();
        return mContentView;
    }


    private void initView() {
        mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
        mQRCodeView.setOnClickListener(this);
        mCategoryView = (TextView) mContentView.findViewById(R.id.category_view);
        mCategoryView.setOnClickListener(this);
        mSearchView = (TextView) mContentView.findViewById(R.id.search_view);
        mSearchView.setOnClickListener(this);
        mListView = (ListView) mContentView.findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
        mLoadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
        //数据加载动画
        AnimationDrawable anim = (AnimationDrawable) mLoadingView.getDrawable();
        anim.start();
    }

    /**
     * 发送推荐产品请求
     */
    private void requestRecommandData() {

        RequestCenter.requestRecommandData(new DisposeDataListener() {

            @Override
            public void onSuccess(Object responseObj) {
                Log.e(TAG,"onSuccess"+responseObj.toString());
                mRecommandData  = (BaseRecommandModel) responseObj;
                //更新UI
                showSuccessView();
            }

            @Override
            public void onFailure(Object reasonObj) {
                Log.e(TAG,"onFailure"+reasonObj.toString());
                //显示请求失败View
                showErrorView();
            }
        });
    }

    private void showSuccessView() {
        if (mRecommandData.data.list != null && mRecommandData.data.list.size() > 0){
            mLoadingView.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
            //为listview添加头
            mListView.addHeaderView(new HomeHeaderLayout(mContext, mRecommandData.data.head));
            mAdapter = new CourseAdapter(mContext, mRecommandData.data.list);
            mListView.setAdapter(mAdapter);
            mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    mAdapter.updateAdInScrollView();
                }
            });


        }else {
            showErrorView();
        }

    }

    private void showErrorView() {
    }


    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.qrcode_view:
                 Intent intent = new Intent(mContext, CaptureActivity.class);
                 startActivityForResult(intent,REQUEST_QRCODE);
                 break;
             case R.id.category_view:
                 break;
             case R.id.search_view:
                 break;

         }


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_QRCODE:
                if (resultCode == Activity.RESULT_OK){
                    String code = data.getStringExtra("SCAN_RESULT");
                    if (code.contains("http") || code.contains("https")) {
                       /* Intent intent = new Intent(mContext, AdBrowserActivity.class);
                        intent.putExtra(AdBrowserActivity.KEY_URL, code);
                        startActivity(intent);*/
                        Toast.makeText(mContext, code, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, code, Toast.LENGTH_SHORT).show();
                    }
                }
                break;

        }


    }
}
