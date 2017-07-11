package com.choi.share_book.presenter.contact;

import android.content.Intent;

/**
 * Created by choi on 2017. 7. 11..
 */

public interface LoginContact {
    interface View {

        void showToast(String title);

        void redirectLoginActivity();

        void redirectSignupActivity();

    }

    interface Presenter {

        void onCreate();

        void onResume();

        void onPause();

        void onDestroy();

        boolean onActivityResult(int requestCode, int resultCode, Intent data);

    }
}
