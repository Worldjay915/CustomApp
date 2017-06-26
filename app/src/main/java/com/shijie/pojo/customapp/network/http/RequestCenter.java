package com.shijie.pojo.customapp.network.http;

import com.shijie.pojo.androidsdk.okhttp.CommonOkHttpClient;
import com.shijie.pojo.androidsdk.okhttp.listener.DisposeDataHandle;
import com.shijie.pojo.androidsdk.okhttp.listener.DisposeDataListener;
import com.shijie.pojo.androidsdk.okhttp.request.CommonRequest;
import com.shijie.pojo.androidsdk.okhttp.request.RequestParams;
import com.shijie.pojo.customapp.module.course.BaseCourseModel;
import com.shijie.pojo.customapp.module.recommand.BaseRecommandModel;
import com.shijie.pojo.customapp.module.update.UpdateModel;
import com.shijie.pojo.customapp.module.user.User;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.network.http
 * 创建者:  zsj
 * 创建事件: 2017/5/11 16:41
 * 描述:  存放应用中所有的网络请求
 */

public class RequestCenter {

    //根据参数发送所有post请求
    public static void postRequest(String url, RequestParams requestParams,
                                   DisposeDataListener listener,Class<?> classz){
        CommonOkHttpClient.post(CommonRequest.createPostRequest(url,requestParams),
                new DisposeDataHandle(listener,classz));
    }

    public static void requestRecommandData(DisposeDataListener listener) {
        RequestCenter.postRequest(HttpConstants.HOME_RECOMMAND, null, listener, BaseRecommandModel.class);
    }

    public static void checkVersion(DisposeDataListener listener) {
        RequestCenter.postRequest(HttpConstants.CHECK_UPDATE, null, listener, UpdateModel.class);
    }
    /**
     * 请求课程详情
     *
     * @param listener
     */
    public static void requestCourseDetail(String courseId, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("courseId", courseId);
        RequestCenter.postRequest(HttpConstants.COURSE_DETAIL, params, listener, BaseCourseModel.class);
    }

    /**
     * 用户登陆请求
     *
     * @param listener
     * @param userName
     * @param passwd
     */
    public static void login(String userName, String passwd, DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("mb", userName);
        params.put("pwd", passwd);
        RequestCenter.postRequest(HttpConstants.LOGIN, params, listener, User.class);
    }

}
