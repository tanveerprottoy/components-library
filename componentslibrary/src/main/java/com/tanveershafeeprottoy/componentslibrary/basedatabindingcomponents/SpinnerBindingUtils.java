package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class SpinnerBindingUtils {

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = { "selectedValue", "selectedValueAttrChanged" }, requireAll = false)
    public static void bindSpinnerData(
        @NonNull AppCompatSpinner appCompatSpinner,
        Object newSelectedValue,
        InverseBindingListener newTextAttrChanged
    ) {
        appCompatSpinner.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(newSelectedValue != null && newSelectedValue == parent.getSelectedItem()) {
                        return;
                    }
                    newTextAttrChanged.onChange();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });
        if(newSelectedValue != null) {
            if(appCompatSpinner.getAdapter() == null) {
                return;
            }
            appCompatSpinner.setSelection(((ArrayAdapter<Object>) appCompatSpinner.getAdapter()).getPosition(newSelectedValue), true);
        }
    }

    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static Object retrieveSelectedValue(@NonNull AppCompatSpinner appCompatSpinner) {
        return appCompatSpinner.getSelectedItem();
    }
}
