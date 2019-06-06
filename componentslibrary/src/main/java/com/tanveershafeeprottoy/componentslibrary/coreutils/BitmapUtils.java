package com.tanveershafeeprottoy.componentslibrary.coreutils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class BitmapUtils {

    public static Bitmap scale(Bitmap bitmap, int width, int height, boolean filter) {
        return Bitmap.createScaledBitmap(bitmap, width, height, filter);
    }

    @Nullable
    public static Bitmap resize(Bitmap bitmap, int newWidth, int newHeight) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float scaleWidth = (float) newWidth / width;
            float scaleHeight = (float) newHeight / height;
            // CREATE A MATRIX FOR THE MANIPULATION
            Matrix matrix = new Matrix();
            // RESIZE THE BITMAP
            matrix.postScale(scaleWidth, scaleHeight);
            // "RECREATE" THE NEW BITMAP
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            //bitmap.recycle() //only recycle if source is not needed to be used
        }
        catch(Exception e) {
            return null;
        }
    }

    public static RoundedBitmapDrawable setRoundedImage(Resources resources, int bitmapRes) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
            resources,
            BitmapFactory.decodeResource(resources, bitmapRes)
        );
        //roundedBitmapDrawable.cornerRadius = Math.max(src.width, src.height) / 2.0f
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }
}
