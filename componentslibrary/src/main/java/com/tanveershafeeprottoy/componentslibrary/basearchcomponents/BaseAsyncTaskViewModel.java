package com.tanveershafeeprottoy.componentslibrary.basearchcomponents;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class BaseAsyncTaskViewModel extends ViewModel {
    public final SingleLiveEvent<Throwable> throwableSingleLiveEvent = new SingleLiveEvent<>();
    public final ObservableBoolean asyncTaskRunningObservableBoolean = new ObservableBoolean(false);

    public void throwError(Throwable throwable) {
        throwableSingleLiveEvent.setValue(throwable);
        resetAsyncTaskRunning();
    }

    public void setAsyncTaskRunning() {
        asyncTaskRunningObservableBoolean.set(true);
    }

    public void resetAsyncTaskRunning() {
        asyncTaskRunningObservableBoolean.set(false);
    }
}
