package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.util.Base64;

import com.valuezier.valuezier.utils.CryptographyUtils;

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
}
