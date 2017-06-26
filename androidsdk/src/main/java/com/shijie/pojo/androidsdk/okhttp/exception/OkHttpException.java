package com.shijie.pojo.androidsdk.okhttp.exception;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp.exception
 * 创建者:  zsj
 * 创建事件: 2017/5/9 19:54
 * 描述:  自定义异常
 */

public class OkHttpException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * the server return code
     */
    private int ecode;

    /**
     * the server return error message
     */
    private Object emsg;

    public OkHttpException(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }


}
