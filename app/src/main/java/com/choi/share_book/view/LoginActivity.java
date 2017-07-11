package com.choi.share_book.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.choi.share_book.R;
import com.choi.share_book.presenter.LoginPresenter;
import com.choi.share_book.presenter.contact.LoginContact;

/**
 * Created by choi on 2017. 7. 11..
 */

public class LoginActivity extends BaseActivity implements LoginContact.View {

    private static final String TAG = LoginActivity.class.getName();
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);
        loginPresenter.onCreate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!loginPresenter.onActivityResult(requestCode, resultCode, data)) {
            return ;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void redirectLoginActivity() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void redirectSignupActivity() {
        startActivity(new Intent(this, KakaoSignupActivity.class));
        finish();
    }
}
