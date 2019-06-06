package com.tanveershafeeprottoy.componentslibrary.networkutils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

public class NetImageUtils {

    public static void load(String path, Target target) {
        Picasso.get().load(path)
               .into(target);
    }

    public static void load(String path, ImageView imageView) {
        Picasso.get().load(path)
               .into(imageView);
    }

    public static void load(String path, ImageView imageView, Drawable errorDrawable) {
        Picasso.get().load(path)
               .error(errorDrawable)
               .into(imageView);
    }

    public static void load(
        String path,
        ImageView imageView,
        int width,
        int height,
        boolean crop
    ) {
        RequestCreator requestCreator = Picasso.get().load(path).resize(width, height);
        if(crop) {
            requestCreator.centerCrop();
        }
        requestCreator.into(imageView);
    }

    public static void load(
        String path,
        ImageView imageView,
        int width,
        int height,
        boolean crop,
        Drawable placeHolderDrawable
    ) {
        RequestCreator requestCreator = Picasso.get().load(path).resize(width, height);
        if(crop) {
            requestCreator.centerCrop();
        }
        requestCreator.placeholder(placeHolderDrawable);
        requestCreator.into(imageView);
    }

    public static void load(
        String path,
        ImageView imageView,
        Drawable errorDrawable,
        int width,
        int height
    ) {
        Picasso.get().load(path)
               .error(errorDrawable)
               .resize(width, height)
               .into(imageView);
    }

    public static void load(String path, int width, int height, Target target) {
        Picasso.get().load(path)
               .resize(width, height)
               .into(target);
    }

    /*public static void load(String path, ImageView imageView, View progressBar, int errorResource) {
        ApplicationUtils.showView(progressBar);
        Picasso.get().load(path)
               .error(errorResource)
               .into(imageView, new Callback() {

                   @Override
                   public void onSuccess() {
                       ApplicationUtils.hideView(progressBar);
                   }

                   @Override
                   public void onError(Exception e) {
                       ApplicationUtils.hideView(progressBar);
                   }
               });
    }

    public static void load(File file, ImageView imageView, View progressBar, int errorResource) {
        ApplicationUtils.showView(progressBar);
        Picasso.get().load(file)
               .error(errorResource)
               .into(imageView, new Callback() {

                   @Override
                   public void onSuccess() {
                       ApplicationUtils.hideView(progressBar);
                   }

                   @Override
                   public void onError(Exception e) {
                       ApplicationUtils.hideView(progressBar);
                   }
               });
    }*/

    public static void loadWithoutCache(String path, ImageView imageView, Drawable errorDrawable) {
        Picasso.get().load(path)
               .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
               .error(errorDrawable)
               .into(imageView);
    }
}
