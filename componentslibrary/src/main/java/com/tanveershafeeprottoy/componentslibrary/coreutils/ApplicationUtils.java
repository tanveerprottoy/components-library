package com.tanveershafeeprottoy.componentslibrary.coreutils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.math.BigDecimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

/**
 * @author Tanveer Shafee Prottoy
 */
public class ApplicationUtils {

    public static void showToastMessage(Context context, String message, int duration) {
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public static void showAlertDialog(
        Context context,
        String title,
        String msg,
        int positiveBtnTextId,
        int negativeBtnTextId,
        DialogInterface.OnClickListener onClickListener,
        boolean isCancellable
    ) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg)
                                        .setPositiveButton(positiveBtnTextId, onClickListener)
                                        .setNegativeButton(negativeBtnTextId, onClickListener)
                                        .setCancelable(isCancellable)
                                        .create().show();
    }

    public static void hideView(@NonNull View view) {
        view.setVisibility(View.GONE);
    }

    public static void showView(@NonNull View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static BigDecimal convertToMonetaryValue(String value) {
        try {
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        catch(NullPointerException | ArithmeticException ex) {
            return new BigDecimal("0.0");
        }
    }
}
