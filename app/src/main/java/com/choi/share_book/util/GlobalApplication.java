package com.choi.share_book.util;

import android.app.Activity;
import android.app.Application;

import com.kakao.auth.KakaoSDK;

/**
 * Created by choi on 2017. 7. 11..
 */

public class GlobalApplication extends Application {

    private static volatile GlobalApplication instance = null;
    private static volatile Activity activity = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    public static GlobalApplication getInstance() {
        if (instance == null) {
            synchronized (GlobalApplication.class) {
                if (instance == null) {
                    return new GlobalApplication();
                }
            }
        }
        return instance;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static void setActivity(Activity activity) {
        GlobalApplication.activity = activity;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
