package com.tanveershafeeprottoy.componentslibrary.basearchcomponents;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * A lifecycle-aware observable that sends only new updates after subscription, used for events like
 * navigation and Snackbar messages.
 * <p>
 * This avoids a common problem with events: on configuration change (like rotation) an update
 * can be emitted if the observer is active. This LiveData only calls the observable if there's an
 * explicit call to setValue() or call().
 * <p>
 * Note that only one observer is going to be notified of changes.
 */
public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static final String TAG = "SingleLiveEvent";
    private AtomicBoolean pending = new AtomicBoolean(false);

    @MainThread
    @Override
    public void observe(
        @NonNull LifecycleOwner owner,
        @NonNull final Observer<? super T> observer
    ) {
        if(hasActiveObservers()) {
            // Multiple observers registered but only one will be notified of changes.;
        }

        // Observe the internal MutableLiveData
        super.observe(owner, t -> {
            if(pending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    @Override
    public void setValue(@Nullable T t) {
        pending.set(true);
        super.setValue(t);
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    public void call() {
        setValue(null);
    }
}
