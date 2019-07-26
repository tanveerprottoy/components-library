package com.tanveershafeeprottoy.componentslibrary.coreutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class FileSaveAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<Context> weakReferenceContext;
    private Bitmap bitmap;
    private String directoryName;
    private String fileNameWithExtension;
    private int quality;
    private boolean append;
    private BitmapSaveAsyncTaskCallback bitmapSaveAsyncTaskCallback;

    public FileSaveAsyncTask(
        WeakReference<Context> weakReferenceContext,
        Bitmap bitmap,
        String directoryName,
        String fileNameWithExtension,
        int quality,
        boolean append,
        BitmapSaveAsyncTaskCallback bitmapSaveAsyncTaskCallback
    ) {
        this.weakReferenceContext = weakReferenceContext;
        this.bitmap = bitmap;
        this.directoryName = directoryName;
        this.fileNameWithExtension = fileNameWithExtension;
        this.quality = quality;
        this.append = append;
        this.bitmapSaveAsyncTaskCallback = bitmapSaveAsyncTaskCallback;
    }

    @Override
    protected String doInBackground(Void... params) {
        return FileUtils.save(
            weakReferenceContext.get(),
            bitmap,
            directoryName,
            fileNameWithExtension,
            quality,
            append
        );
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        bitmapSaveAsyncTaskCallback.onCompleteBitmapSave(result);
    }

    public interface BitmapSaveAsyncTaskCallback {

        void onCompleteBitmapSave(String path);
    }
}
