package com.choi.share_book.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.choi.share_book.R;
import com.choi.share_book.util.ImageUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.image);
        ImageView image2 = (ImageView) findViewById(R.id.image2);

        image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.test_img));

//        image.setImageBitmap(
//                ImageUtils.decodeSampleBitmapFromResource(getResources(), R.drawable.test_img,
//                        LinearLayout.LayoutParams.MATCH_PARENT, 300)
//        );

//        onKakaoLogout(this);

//        onKakaoLoginCheck(this);
    }


}
