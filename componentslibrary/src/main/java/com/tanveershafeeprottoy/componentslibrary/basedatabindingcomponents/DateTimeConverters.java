package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.text.format.DateUtils;

import com.tanveershafeeprottoy.componentslibrary.coreutils.DateTimeUtils;

import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.NonNull;

public class DateTimeConverters {

    @NonNull
    public static String dateTimeToRelativeTimeSpan(String dateTime) {
        try {
            return DateTimeUtils.getRelativeTimeSpanString(
                DateTimeUtils.getDate(
                    DateTimeUtils.DATE_TIME_PATTERN_TIMEZONE_OFFSET,
                    dateTime,
                    Locale.getDefault(),
                    TimeZone.getDefault()
                ).getTime(),
                DateTimeUtils.getCurrentTimeMillis(),
                DateUtils.SECOND_IN_MILLIS,
                0
            );
        }
        catch(Exception e) {
            return "";
        }
    }

    @NonNull
    public static String dateTimeToTimeSpan(String dateTime) {
        try {
            return DateTimeUtils.getRelativeTimeSpanString(
                DateTimeUtils.dateTimeToTimeSpan(
                    DateTimeUtils.DATE_TIME_PATTERN_TIMEZONE_OFFSET,
                    dateTime
                ).getTime(),
                DateTimeUtils.getCurrentTimeMillis(),
                DateUtils.SECOND_IN_MILLIS,
                0
            );
        }
        catch(Exception e) {
            return "";
        }
    }
}
