package com.choi.share_book.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by choi on 2017. 9. 8..
 */

public class ImageUtils {

    private ImageUtils() {
    }

    private static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;

        /**
         * 리사이징을 위한 decoder가 inSampleSize를 2의 배수에 가까운 수로 버림하여 계산하기 때문에 2의 배수로 값을 계산
         * 선처리된 높이와 폭을 바탕으로 이미지를 표시할 뷰의 크기보다 작지 않은 크기로 가장 큰 inSampleSize값을 산출
         */
        if (height > reqHeight || width > reqHeight) {
            final int halfWidth = width / 2;
            final int halfHeight = height / 2;

            while ((halfWidth / inSampleSize) > reqWidth
                    && (halfHeight / inSampleSize) > reqHeight) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources res, int resId,
                                                  int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
