package com.choi.share_book.presenter;

import android.util.Log;

import com.choi.share_book.presenter.contact.KakaoSignupContact;
import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;

/**
 * Created by choi on 2017. 7. 11..
 */

public class KakaoSignupPresenter implements KakaoSignupContact.Presenter {

    private static final String TAG = KakaoSignupPresenter.class.getName();
    private KakaoSignupContact.View view;

    public KakaoSignupPresenter(KakaoSignupContact.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        requestUserInfo();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    private void requestUserInfo() {
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Logger.e(errorResult.toString());
                ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());
                if (result == ErrorCode.CLIENT_ERROR_CODE) {
                    view.finish();
                } else {
                    view.redirectLoginActivity();
                }
            }

            @Override
            public void onNotSignedUp() {
                view.showToast("카카오톡 회원 조회를 실패했습니다.");
            }

            @Override
            public void onSuccess(UserProfile result) {
                Logger.d(result.toString());
                requestSignup(result);
            }
        });
    }

    private void requestSignup(UserProfile profile) {
        long kakaoID = profile.getId();
        String kakaoEmail = profile.getEmail();
        Log.d(TAG, "ID : "+kakaoID+", Email : "+kakaoEmail);
        view.redirectMainActivity();
    }
}
