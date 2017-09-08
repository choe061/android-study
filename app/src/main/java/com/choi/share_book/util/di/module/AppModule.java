package com.choi.share_book.util.di.module;

import android.app.Application;

import com.choi.share_book.util.KakaoSDKAdapter;
import com.kakao.auth.KakaoSDK;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by choi on 2017. 7. 14..
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
//        KakaoSDK.init(new KakaoSDKAdapter());
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }
}
