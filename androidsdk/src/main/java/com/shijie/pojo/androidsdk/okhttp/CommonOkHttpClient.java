package com.shijie.pojo.androidsdk.okhttp;

import com.shijie.pojo.androidsdk.okhttp.cookie.SimpleCookieJar;
import com.shijie.pojo.androidsdk.okhttp.https.HttpsUtils;
import com.shijie.pojo.androidsdk.okhttp.listener.DisposeDataHandle;
import com.shijie.pojo.androidsdk.okhttp.response.CommonFileCallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk
 * 创建者:  zsj
 * 创建事件: 2017/5/9 20:04
 * 描述:   OkHttpClient 封装
 * 用来发送get, post请求的工具类，包括设置一些请求的共用参数
 */

public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    static{
        OkHttpClient.Builder okHttpClienBuilder = new OkHttpClient.Builder();
        //验证用户签名
        okHttpClienBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        /**
         *为所有请求添加请求头，看个人需求
         */
        okHttpClienBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("User-Agent", "Imooc-Mobile") // 标明发送本次请求的客户端
                        .build();
                return chain.proceed(request);
            }
        });

        okHttpClienBuilder.cookieJar(new SimpleCookieJar()); //设置cookie
        okHttpClienBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClienBuilder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpClienBuilder.connectTimeout(TIME_OUT,TimeUnit.SECONDS);
        //支持https
        okHttpClienBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),HttpsUtils.initTrustManager());

        mOkHttpClient = okHttpClienBuilder.build();
    }


    public static OkHttpClient getmOkHttpClient(){
        return  mOkHttpClient;
    }

    public static Call get(Request request , DisposeDataHandle disposeDataHandle){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(disposeDataHandle));
        return call;
    }

    public static Call post(Request request,DisposeDataHandle disposeDataHandle){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(disposeDataHandle));
        return call;
    }

    public static Call downloadFile(Request request, DisposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonFileCallback(handle));
        return call;
    }

}
