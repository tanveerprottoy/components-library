package com.tanveershafeeprottoy.componentslibrary.coreutils;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

public class IntentUtils {

    private static void showErrorMessage(@NonNull AppCompatActivity appCompatActivity) {
        ApplicationUtils.showToastMessage(
            appCompatActivity.getApplicationContext(),
            "Activity not found",
            Toast.LENGTH_LONG
        );
    }

    public static Intent createCameraIntent(
        File file,
        AppCompatActivity appCompatActivity,
        String authorities,
        String label  //photo
    ) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri outputUri = FileProvider.getUriForFile(appCompatActivity, authorities, file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        else {
            ClipData clip = ClipData.newUri(
                appCompatActivity.getContentResolver(),
                label,
                outputUri
            );
            intent.setClipData(clip);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        return intent;
    }

    public static void startActivityWithImplicitIntent(
        @NonNull AppCompatActivity appCompatActivity,
        String action
    ) {
        try {
            appCompatActivity.startActivity(new Intent(action));
        }
        catch(ActivityNotFoundException a) {
            showErrorMessage(appCompatActivity);
        }
    }

    public static void startActivityWithImplicitIntent(
        @NonNull AppCompatActivity appCompatActivity,
        String action,
        Uri uri
    ) {
        try {
            appCompatActivity.startActivity(new Intent(action, uri));
        }
        catch(ActivityNotFoundException a) {
            showErrorMessage(appCompatActivity);
        }
    }

    public static void startActivityForResultWithImplicitIntent(
        @NonNull AppCompatActivity appCompatActivity,
        String action,
        int requestCode
    ) {
        try {
            appCompatActivity.startActivityForResult(new Intent(action), requestCode);
        }
        catch(ActivityNotFoundException a) {
            showErrorMessage(appCompatActivity);
        }
    }

    public static void startActivityWithCameraIntent(
        File file,
        AppCompatActivity appCompatActivity,
        String authorities,
        String label,  //photo
        int requestCode
    ) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri outputUri = FileProvider.getUriForFile(appCompatActivity, authorities, file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        else {
            ClipData clip = ClipData.newUri(
                appCompatActivity.getContentResolver(),
                label,
                outputUri
            );
            intent.setClipData(clip);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }

        //for less than 19 build
/*        val resInfoList: List<ResolveInfo> = context.getPackageManager()
                .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        for(resolveInfo: ResolveInfo in resInfoList) {
            val packageName = resolveInfo.activityInfo.packageName;
            context.grantUriPermission(packageName, outputUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }*/
        try {
            appCompatActivity.startActivityForResult(intent, requestCode);
        }
        catch(ActivityNotFoundException a) {
            showErrorMessage(appCompatActivity);
        }
    }

    public static void startActivityWithEmailIntent(
        @NonNull AppCompatActivity appCompatActivity,
        String[] addressArray
    ) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addressArray);
            appCompatActivity.startActivity(intent);
        }
        catch(ActivityNotFoundException a) {
            showErrorMessage(appCompatActivity);
        }
    }
}
