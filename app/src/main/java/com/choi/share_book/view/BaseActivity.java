package com.choi.share_book.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.choi.share_book.App;
import com.choi.share_book.network.HttpService;
import com.kakao.auth.Session;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by choi on 2017. 7. 11..
 */

public class BaseActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;

    @Inject
    SharedPreferences sharedPreferences;

    public HttpService httpService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        httpService = retrofit.create(HttpService.class);
    }

    protected final void onKakaoLoginCheck(Activity activity) {
        if (Session.getCurrentSession().isClosed()) {
            startActivity(new Intent(activity, LoginActivity.class));
            finish();
        }
    }

    protected final void onKakaoLogout(Activity activity) {
        UserManagement.requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                startActivity(new Intent(activity, LoginActivity.class));
            }
        });
    }
}
