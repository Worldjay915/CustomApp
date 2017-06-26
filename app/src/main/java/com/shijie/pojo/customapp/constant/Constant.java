package com.shijie.pojo.customapp.constant;

import android.Manifest;
import android.os.Environment;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.constant
 * 创建者:  zsj
 * 创建事件: 2017/5/21 11:49
 * 描述:  常量
 */

public class Constant {

    /**
     * 权限常量相关
     */
    public static final int WRITE_READ_EXTERNAL_CODE = 0x01;
    public static final String[] WRITE_READ_EXTERNAL_PERMISSION = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    public static final int HARDWEAR_CAMERA_CODE = 0x02;
    public static final String[] HARDWEAR_CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};

    //整个应用文件下载保存路径
    public static String APP_PHOTO_DIR = Environment.
            getExternalStorageDirectory().getAbsolutePath().
            concat("/imooc_business/photo/");

}
