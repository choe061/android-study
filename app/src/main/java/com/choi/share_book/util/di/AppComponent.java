package com.choi.share_book.util.di;

import com.choi.share_book.util.di.module.AppModule;
import com.choi.share_book.util.di.module.NetModule;
import com.choi.share_book.view.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by choi on 2017. 7. 11..
 */

@Singleton
@Component(modules = {NetModule.class, AppModule.class})
public interface AppComponent {
    void inject(BaseActivity activity);
}
