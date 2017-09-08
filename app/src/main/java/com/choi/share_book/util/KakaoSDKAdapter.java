package com.choi.share_book.util;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.choi.share_book.App;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;

import javax.inject.Inject;

/**
 * Created by choi on 2017. 7. 11..
 */

public class KakaoSDKAdapter extends KakaoAdapter {

    @Inject
    Application application;

    @Override
    public IApplicationConfig getApplicationConfig() {
        App.getAppComponent().inject(this);
        IApplicationConfig config = new IApplicationConfig() {
            @Override
            public Context getApplicationContext() {
                return application;
            }
        };
        return config;
    }
}
