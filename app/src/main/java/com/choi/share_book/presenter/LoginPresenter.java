package com.choi.share_book.presenter;

import android.content.Intent;
import android.util.Log;

import com.choi.share_book.presenter.contact.LoginContact;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

/**
 * Created by choi on 2017. 7. 11..
 */

public class LoginPresenter implements LoginContact.Presenter {

    private static final String TAG = LoginPresenter.class.getName();
    private LoginContact.View view;

    private SessionCallback callback;
    private Session session;

    public LoginPresenter(LoginContact.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        callback = new SessionCallback();
        session = Session.getCurrentSession();
        session.addCallback(callback);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        session.removeCallback(callback);
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (session.handleActivityResult(requestCode, resultCode, data)) {
            return false;
        }
        return true;
    }

    private class SessionCallback implements ISessionCallback {

        //세션 연결 성공 시
        @Override
        public void onSessionOpened() {
            view.redirectSignupActivity();
        }
        //세션 연결 실패 시
        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Logger.e(exception);
            }
            //로그인 화면을 다시 화면을 띄움
            view.redirectLoginActivity();
        }
    }
}
