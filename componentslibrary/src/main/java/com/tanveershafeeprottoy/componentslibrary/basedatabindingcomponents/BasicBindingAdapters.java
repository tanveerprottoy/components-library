package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.tanveershafeeprottoy.componentslibrary.networkutils.NetImageUtils;

import androidx.databinding.BindingAdapter;

public class BasicBindingAdapters {

    @BindingAdapter({ "imageUrl" })
    public static void loadImage(ImageView imageView, String url) {
        NetImageUtils.load(url, imageView);
    }

    @BindingAdapter({ "imageUrl", "errorDrawable" })
    public static void loadImage(ImageView imageView, String url, Drawable errorDrawable) {
        NetImageUtils.load(url, imageView, errorDrawable);
    }

    @BindingAdapter({ "imageUrl", "imageWidth", "imageHeight", "crop" })
    public static void loadImage(
        ImageView imageView,
        String url,
        float imageWidth,
        float imageHeight,
        boolean crop
    ) {
        NetImageUtils.load(
            url,
            imageView,
            (int) imageWidth,
            (int) imageHeight,
            crop
        );
    }

    @BindingAdapter({ "imageUrl", "imageWidth", "imageHeight", "crop", "placeHolder" })
    public static void loadImage(
        ImageView imageView,
        String url,
        float imageWidth,
        float imageHeight,
        boolean crop,
        Drawable placeHolderDrawable
    ) {
        NetImageUtils.load(
            url,
            imageView,
            (int) imageWidth,
            (int) imageHeight,
            crop,
            placeHolderDrawable
        );
    }
}