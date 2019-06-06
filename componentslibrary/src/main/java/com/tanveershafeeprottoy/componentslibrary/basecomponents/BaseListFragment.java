package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import android.os.Bundle;

import com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents.BaseListAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class BaseListFragment<T> extends Fragment {
    protected BaseListAdapter<T> baseListAdapter;
    protected FragmentActivity fragmentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = getActivity();
    }
}
