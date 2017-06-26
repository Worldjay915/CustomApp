package com.shijie.pojo.androidsdk.okhttp.listener;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp.listener
 * 创建者:  zsj
 * 创建事件: 2017/5/9 20:03
 * 描述:  处理数据类
 */

public class DisposeDataHandle {
    /**
     *  处理数据类 需要包含
     *  处理成功和失败的接口(DisposeDataListener)
     *  处理的实体类  Class 或 String 字符
     */
    public DisposeDataListener mListener = null;
    public Class<?> mClass = null;
    public String mSource = null;

    public DisposeDataHandle(DisposeDataListener listener)
    {
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener, Class<?> clazz)
    {
        this.mListener = listener;
        this.mClass = clazz;
    }

    public DisposeDataHandle(DisposeDataListener listener, String source)
    {
        this.mListener = listener;
        this.mSource = source;
    }

}
