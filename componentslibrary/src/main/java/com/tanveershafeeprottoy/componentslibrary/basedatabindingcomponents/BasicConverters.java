package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.util.Base64;

import com.tanveershafeeprottoy.componentslibrary.crypto.CryptographyUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import androidx.annotation.NonNull;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BasicConverters {

    @NonNull
    public static String intToString(int integer) {
        try {
            return String.valueOf(integer);
        }
        catch(Exception e) {
            return "";
        }
    }

    @NonNull
    public static String doubleToString(double doubleVal) {
        try {
            return String.valueOf(doubleVal);
        }
        catch(Exception e) {
            return "";
        }
    }

    // only for crypto

    @NonNull
    public static String decodeToString(String encryptedData, String privateKey) {
        try {
            return CryptographyUtils.decodeToString(
                CryptographyUtils.decryptRSA(
                    CryptographyUtils.stringToPrivateKey(privateKey),
                    Base64.decode(encryptedData, Base64.DEFAULT)
                )
            );
        }
        catch(Exception e) {
            return "";
        }
    }

    public static int stringToInt(String stringVal) {
        try {
            return Integer.parseInt(stringVal);
        }
        catch(Exception e) {
            return 0;
        }
    }

    public static float stringToFloat(String stringVal) {
        try {
            return Float.parseFloat(stringVal);
        }
        catch(Exception e) {
            return 0;
        }
    }

    /**
     * will be used for showing monetary value in UI
     */
    public static String stringToMonetaryString(String stringVal) {
        try {
            BigDecimal bigDecimal = new BigDecimal(stringVal);
            bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
            DecimalFormat decimalFormat = new DecimalFormat("#0.0#");
            return decimalFormat.format(bigDecimal.doubleValue());
        }
        catch(Exception e) {
            return "0.0";
        }
    }

    /**
     * will be used for showing monetary value in UI, converted from double
     */
    public static String doubleToMonetaryString(double doubleVal) {
        try {
            BigDecimal bigDecimal = new BigDecimal(doubleVal);
            bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
            return String.valueOf(bigDecimal.doubleValue());
        }
        catch(Exception e) {
            return "";
        }
    }
}
