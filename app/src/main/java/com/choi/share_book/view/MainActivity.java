package com.choi.share_book.view;

import android.os.Bundle;

import com.choi.share_book.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        onKakaoLogout(this);

        onKakaoLoginCheck(this);
    }

}
