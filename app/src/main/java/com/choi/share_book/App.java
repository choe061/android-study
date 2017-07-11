package com.choi.share_book;

import android.app.Activity;
import android.app.Application;

import com.choi.share_book.util.Constants;
import com.choi.share_book.util.KakaoSDKAdapter;
import com.choi.share_book.util.di.AppComponent;
import com.choi.share_book.util.di.DaggerAppComponent;
import com.choi.share_book.util.di.module.NetModule;
import com.kakao.auth.KakaoSDK;

/**
 * Created by choi on 2017. 7. 11..
 */

public class App extends Application {
    private AppComponent appComponent;
    private static volatile App instance = null;
    private static volatile Activity activity = null;

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .build();
        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getInstance() {
        if (instance == null) {
            synchronized (App.class) {
                if (instance == null) {
//                    return new App();
                }
            }
        }
        return instance;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static void setActivity(Activity activity) {
        App.activity = activity;
    }
}
