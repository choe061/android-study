package com.choi.share_book.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.choi.share_book.presenter.KakaoSignupPresenter;
import com.choi.share_book.presenter.contact.KakaoSignupContact;

/**
 * Created by choi on 2017. 7. 11..
 */

public class KakaoSignupActivity extends BaseActivity implements KakaoSignupContact.View {

    private KakaoSignupPresenter kakaoSignupPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kakaoSignupPresenter = new KakaoSignupPresenter(this, httpService);
        kakaoSignupPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        kakaoSignupPresenter.onDestroy();
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void redirectMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void redirectLoginActivity() {
        final Intent intent = new Intent(this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

}
