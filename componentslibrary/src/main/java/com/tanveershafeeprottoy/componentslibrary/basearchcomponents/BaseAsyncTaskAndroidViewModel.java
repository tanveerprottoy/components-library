package com.tanveershafeeprottoy.componentslibrary.basearchcomponents;

import android.app.Application;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;

public class BaseAsyncTaskAndroidViewModel extends AndroidViewModel {
    public final SingleLiveEvent<Throwable> throwableSingleLiveEvent = new SingleLiveEvent<>();
    public final ObservableBoolean asyncTaskRunningObservableBoolean = new ObservableBoolean(false);

    public BaseAsyncTaskAndroidViewModel(Application application) {
        super(application);
    }

    protected void throwError(Throwable throwable) {
        throwableSingleLiveEvent.setValue(throwable);
    }
}
