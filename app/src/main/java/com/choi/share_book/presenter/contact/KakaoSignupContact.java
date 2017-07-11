package com.choi.share_book.presenter.contact;

/**
 * Created by choi on 2017. 7. 11..
 */

public interface KakaoSignupContact {

    interface View {

        void showToast(String title);

        void redirectLoginActivity();

        void redirectMainActivity();

        void finish();

    }

    interface Presenter {

        void onCreate();

        void onResume();

        void onPause();

        void onDestroy();

    }
}
