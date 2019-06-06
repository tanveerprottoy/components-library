package com.tanveershafeeprottoy.componentslibrary.coreutils;

import android.app.TimePickerDialog;
import android.content.Context;
import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DateTimeUtils {
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_USER_FACING = "dd/MM/yyyy";
    public static final String TIME_PATTERN_TWELVE = "h:mm a";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String DAY_PATTERN = "dd";
    public static final String MONTH_PATTERN = "MM";
    public static final String TIME_PATTERN_FULL = "HH:mm:ss";
    public static final String TIME_PATTERN_24 = "HH:mm";
    public static final String MONTH_DAY_PATTERN = "MMM d";
    public static final String DATE_TIME_PATTERN_TIMEZONE_OFFSET = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getFormattedDateTime(String pattern) {
        try {
            return new SimpleDateFormat(
                pattern,
                Locale.getDefault()
            ).format(Calendar.getInstance().getTime());
        }
        catch(Exception e) {
            return "";
        }
    }

    public static String getFormattedDateTime(String pattern, Locale locale) {
        try {
            return new SimpleDateFormat(pattern, locale).format(Calendar.getInstance().getTime());
        }
        catch(Exception e) {
            return "";
        }
    }

    public static String getFormattedDateTime(
        String pattern,
        Calendar calendar,
        Locale locale
    ) {
        try {
            return new SimpleDateFormat(pattern, locale).format(calendar.getTime());
        }
        catch(Exception e) {
            return "";
        }
    }

    public static String getFormattedDateTime(
        String pattern,
        Date date,
        Locale locale
    ) {
        try {
            return new SimpleDateFormat(pattern, locale).format(date);
        }
        catch(Exception e) {
            return "";
        }
    }

    public static String getFormattedDateTime(
        String pattern,
        Date date,
        TimeZone timeZone,
        Locale locale
    ) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.format(date);
        }
        catch(Exception e) {
            return "";
        }
    }

    public static Date getDate(String pattern, String date, Locale locale) {
        try {
            return new SimpleDateFormat(pattern, locale).parse(date);
        }
        catch(ParseException p) {
            return null;
        }
    }

    public static Date getDate(
        String pattern,
        String date,
        Locale locale,
        TimeZone timeZone
    ) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.parse(date);
        }
        catch(ParseException p) {
            return null;
        }
    }

    @Nullable
    public static Date getDateTimeFromMills(long timeInMillis) {
        try {
            return new Date(timeInMillis);
        }
        catch(Exception e) {
            return null;
        }
    }

    @NonNull
    public static String getRelativeTimeSpanString(
        long time,
        long now,
        long minResolution,
        int flags
    ) {
        return DateUtils.getRelativeTimeSpanString(time, now, minResolution, flags).toString();
    }

    @NonNull
    public static String getRelativeDateTimeString(
        Context context,
        long time,
        long minResolution,
        long transitionResolution,
        int flags
    ) {
        return DateUtils.getRelativeDateTimeString(
            context,
            time,
            minResolution,
            transitionResolution,
            flags
        ).toString();
    }

    @Nullable
    public static Date dateTimeToTimeSpan(
        String pattern,
        String date
    ) {
        try {
            SimpleDateFormat sourceFormat = new SimpleDateFormat(pattern);
            sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date parsed = sourceFormat.parse(date); // => Date is in UTC now

            TimeZone tz = TimeZone.getDefault();
            SimpleDateFormat destFormat = new SimpleDateFormat(pattern);
            destFormat.setTimeZone(tz);

            String result = destFormat.format(parsed);
            return getDate(pattern, result, Locale.getDefault());
        }
        catch(Exception e) {
            return null;
        }
    }

    /*
    fun showDatePicker(fragmentManager:FragmentManager) {
        DatePickerDialogFragment.newInstance().show(fragmentManager, "DatePickerDialogFragment")
    }*/

/*    fun showDatePicker(appCompatActivity: AppCompatActivity, onDateSetListener: DatePickerDialog.OnDateSetListener) {
        val calendar = Calendar.getInstance()
        DatePickerDialog(appCompatActivity, onDateSetListener, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
    }*/

/*    fun showDatePicker(fragmentActivity: FragmentActivity, onDateSetListener: DatePickerDialog.OnDateSetListener) {
        val calendar = Calendar.getInstance()
        DatePickerDialog(fragmentActivity, onDateSetListener, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
    }*/

    /**
     * caller of this function must implement
     *
     * @see TimePickerDialog.OnTimeSetListener
     */
    /*fun showTimePicker(fragmentManager:FragmentManager, isTwentyFourHour:Boolean) {
        TimePickerDialogFragment.newInstance(isTwentyFourHour)
                                .show(
                                    fragmentManager,
                                    "TimePickerFragment"
                                )   //DateFormat.is24HourFormat(fragmentActivity)
    }

    fun showTimePicker(
        fragmentActivity:FragmentActivity,
        onTimeSetListener:TimePickerDialog.OnTimeSetListener,
        isTwentyFourHour:Boolean
    ) {
        val calendar = Calendar.getInstance()
        TimePickerDialog(
            fragmentActivity,
            onTimeSetListener,
            calendar
                .get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            isTwentyFourHour
        ).show()   //DateFormat.is24HourFormat(fragmentActivity)
    }*/
}
