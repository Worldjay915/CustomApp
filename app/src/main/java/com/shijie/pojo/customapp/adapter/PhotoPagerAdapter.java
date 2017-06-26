package com.shijie.pojo.customapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.shijie.pojo.customapp.activity.CourseDetailActivity;
import com.shijie.pojo.customapp.util.ImageLoaderManager;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;


/**
 *   头部ads广告布局
 */
public class PhotoPagerAdapter extends PagerAdapter {

    private Context mContext;

    private boolean mIsMatch;
    private ArrayList<String> mData;
    private ImageLoaderManager mLoader;

    public PhotoPagerAdapter(Context context, ArrayList<String> list, boolean isMatch) {
        mContext = context;
        mData = list;
        mIsMatch = isMatch;
        mLoader = ImageLoaderManager.getInstance(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        ImageView photoView;
        if (mIsMatch) {
            photoView = new ImageView(mContext);
            photoView.setScaleType(ScaleType.FIT_XY);
            photoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,
                            CourseDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });
        } else {
            photoView = new PhotoView(mContext);
        }
        mLoader.displayImage(photoView, mData.get(position));
        container.addView(photoView, LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
