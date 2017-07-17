package com.choi.share_book.presenter;

import android.util.Log;
import android.widget.Toast;

import com.choi.share_book.model.api.UserApi;
import com.choi.share_book.model.domain.User;
import com.choi.share_book.network.ApiCallback;
import com.choi.share_book.network.HttpService;
import com.choi.share_book.network.RestResponse;
import com.choi.share_book.presenter.contact.KakaoSignupContact;
import com.google.firebase.iid.FirebaseInstanceId;
import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by choi on 2017. 7. 11..
 */

public class KakaoSignupPresenter implements KakaoSignupContact.Presenter {

    private static final String TAG = KakaoSignupPresenter.class.getName();
    private KakaoSignupContact.View view;
    private UserApi userApi;
    private CompositeDisposable compositeDisposable;

    public KakaoSignupPresenter(KakaoSignupContact.View view, HttpService httpService) {
        this.view = view;
        this.userApi = new UserApi(httpService);
        this.compositeDisposable = new CompositeDisposable();
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
        compositeDisposable.dispose();
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
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        User user = new User(profile.getId(), profile.getEmail(),
                profile.getProfileImagePath(), profile.getNickname(), refreshedToken);
        Disposable disposable = userApi.requestCreateUser(user, new ApiCallback<RestResponse>() {
            @Override
            public void onSuccess(RestResponse model) {
                //가입 완료
                view.redirectMainActivity();
            }

            @Override
            public void onError(String msg) {
                //가입 실패
                Logger.e(msg);
                view.showToast("오류가 발생했습니다. 다시 시도해주세요.");
                view.redirectLoginActivity();
            }
        });
        compositeDisposable.add(disposable);
    }
}
