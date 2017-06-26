package com.shijie.pojo.androidsdk.okhttp.cookie;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.androidsdk.okhttp.cookie
 * 创建者:  zsj
 * 创建事件: 2017/5/10 15:17
 * 描述:  设置cookie (为HTTP cookie提供策略和持久性)
 * Provides policy and persistence for HTTP cookies.
 */

public class SimpleCookieJar implements CookieJar{

    private final List<Cookie> allCookies = new ArrayList<>();

    @Override
    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        allCookies.addAll(cookies);
    }

    @Override
    public synchronized List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> result = new ArrayList<>();
        for (Cookie cookie : allCookies) {
            if (cookie.matches(url)) {
                result.add(cookie);
            }
        }
        return result;
    }
}
