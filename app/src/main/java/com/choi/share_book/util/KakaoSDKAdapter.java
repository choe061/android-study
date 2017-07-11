package com.choi.share_book.util;

import android.content.Context;

import com.choi.share_book.App;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;

/**
 * Created by choi on 2017. 7. 11..
 */

public class KakaoSDKAdapter extends KakaoAdapter {
    @Override
    public IApplicationConfig getApplicationConfig() {
        IApplicationConfig config = new IApplicationConfig() {
            @Override
            public Context getApplicationContext() {
                return App.getInstance();
            }
        };
        return config;
    }
}
