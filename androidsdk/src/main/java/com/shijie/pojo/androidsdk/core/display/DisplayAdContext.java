package com.shijie.pojo.androidsdk.core.display;

import android.view.ViewGroup;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.core.display
 * 创建者:  zsj
 * 创建事件: 2017/5/15 9:51
 * 描述: 用来与外界通信的类， 接收参数， 发送请求
 */

public class DisplayAdContext implements
        DisplayAdSlot.DisplayConextListener{
    /**
     * Data
     */
    private DisplayAdSlot mDisplayAdSlot; //图片类型广告
    private DisplayAdAppListener mAdAppListener;

    public DisplayAdContext(ViewGroup parentView) {
        mDisplayAdSlot = new DisplayAdSlot(parentView);
        mDisplayAdSlot.setContextListener(this);
    }

    public void setAdAppListener(DisplayAdAppListener listener) {
        mAdAppListener = listener;
    }

    @Override
    public void onLoadingComplete() {
        if (mAdAppListener != null) {
            mAdAppListener.onLoadingComplete();
        }
    }

    //真正的加载图片失败
    @Override
    public void onLoadingFailed() {
        if (mAdAppListener != null) {
            mAdAppListener.onLoadingFailed();
        }
    }

    public void onDispose() {
        if (mDisplayAdSlot != null) {
            mDisplayAdSlot.onDispose();
        }
    }

    public interface DisplayAdAppListener {

        void onLoadingComplete();

        void onLoadingFailed();
    }


}
