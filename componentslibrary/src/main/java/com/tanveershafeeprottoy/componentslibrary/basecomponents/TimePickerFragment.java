package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public class TimePickerFragment extends DialogFragment {
    private TimePickerDialog.OnTimeSetListener onTimeSetListener;

    public TimePickerFragment() {
    }

    @NonNull
    public static TimePickerFragment newInstance() {
        return new TimePickerFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        FragmentActivity fragmentActivity = getActivity();

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(
            fragmentActivity,
            onTimeSetListener,
            hour,
            minute,
            DateFormat.is24HourFormat(fragmentActivity)
        );
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TimePickerDialog.OnTimeSetListener) {
            onTimeSetListener = (TimePickerDialog.OnTimeSetListener) context;
        }
        else {
            throw new RuntimeException(
                "Hosting activity must implement TimePickerDialog.OnTimeSetListener"
            );
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onTimeSetListener = null;
    }
}
