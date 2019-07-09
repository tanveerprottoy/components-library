package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.text.format.DateUtils;

import com.valuezier.valuezier.coreutils.DateTimeUtils;

import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.NonNull;

public class DateTimeConverters {

    @NonNull
    private static String date(String dateTime) {
        try {
            return DateTimeUtils.getRelativeTimeSpanString(
                DateTimeUtils.getDate(
                    DateTimeUtils.DATE_TIME_PATTERN_FULL_MILLISECOND,
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
    public static String dateTimeToRelativeTimeSpan(String dateTime) {
        try {
            String pattern = DateTimeUtils.DATE_TIME_PATTERN_TIMEZONE_OFFSET;
            if(dateTime.contains("+")) {
                pattern = DateTimeUtils.DATE_TIME_PATTERN_FULL_MILLISECOND;
            }
            return DateTimeUtils.getRelativeTimeSpanString(
                DateTimeUtils.getDateForCurrentZone(
                    pattern,
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
