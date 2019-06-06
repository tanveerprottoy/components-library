package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableBoolean;

/**
 * Created by Tanveer Shafee Prottoy on 12/25/18.
 */
public class BaseValidatableObservable extends BaseObservable {
    public final ObservableBoolean isValidInput = new ObservableBoolean(false);
}
