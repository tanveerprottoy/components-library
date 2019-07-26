package com.tanveershafeeprottoy.componentslibrary.coreutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FileUtils {

    @Nullable
    public static File createFile(Context context, String child, String rootChild) {
        try {
            File file = new File(new File(context.getFilesDir(), child), rootChild);
            if(file.exists()) {
                file.delete();
            }
            else {
                file.getParentFile().mkdirs();
            }
            return file;
        }
        catch(Exception e) {
            return null;
        }
    }

    @Nullable
    public static String save(
        @NonNull Context context,
        Bitmap bitmap,
        String directoryName,
        String fileNameWithExtension,
        int quality,
        boolean append
    ) {
        File directoryFile = context.getDir(directoryName, Context.MODE_PRIVATE);
        if(!directoryFile.exists()) {
            directoryFile.mkdir();
        }
        // Create image
        File imageFile = new File(directoryFile, fileNameWithExtension);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(imageFile, append);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
        }
        catch(FileNotFoundException f) {
            return null;
        }
        finally {
            try {
                fileOutputStream.close();
            }
            catch(IOException | NullPointerException e) {

            }
        }
        return directoryFile.getAbsolutePath();
    }

    @Nullable
    public static String save(
        @NonNull Context context,
        Uri uri,
        String directoryName,
        String fileNameWithExtension,
        int quality,
        boolean append
    ) {
        File directoryFile = context.getDir(directoryName, Context.MODE_PRIVATE);
        if(!directoryFile.exists()) {
            directoryFile.mkdir();
        }
        // Create file
        File otherFile = new File(directoryFile, fileNameWithExtension);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(otherFile, append);
            // Use the compress method on the BitMap object to write image to the OutputStream
//            fileOutputStream.write();
        }
        catch(FileNotFoundException f) {
            return null;
        }
        finally {
            try {
                fileOutputStream.close();
            }
            catch(IOException | NullPointerException e) {

            }
        }
        return directoryFile.getAbsolutePath();
    }

    @NonNull
    public static File loadFile(String path, String name) {
        return new File(path, name);
    }

    @Nullable
    public static Bitmap loadBitmap(String path, String name) {
        try {
            return BitmapFactory.decodeStream(new FileInputStream(new File(path, name)));
        }
        catch(Exception e) {
            return null;
        }
    }
}
