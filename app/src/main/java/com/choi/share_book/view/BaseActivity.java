package com.choi.share_book.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.choi.share_book.App;
import com.choi.share_book.network.HttpService;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by choi on 2017. 7. 11..
 */

public class BaseActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;

    public HttpService httpService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        httpService = retrofit.create(HttpService.class);
    }
}
