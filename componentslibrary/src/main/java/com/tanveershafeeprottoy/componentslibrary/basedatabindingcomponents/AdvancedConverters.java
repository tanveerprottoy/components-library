package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import androidx.databinding.InverseMethod;

public class AdvancedConverters {

    @InverseMethod("stringToInt")
    public static String intToString(
        int value
    ) {
        try {
            return String.valueOf(value);
        }
        catch(Exception e) {
            return "";
        }
    }

    public static int stringToInt(
        String value
    ) {
        try {
            return Integer.parseInt(value);
        }
        catch(Exception e) {
            return 0;
        }
    }
}
