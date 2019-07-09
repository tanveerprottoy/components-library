package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class BaseListFragment<T extends BaseListItemModel> extends Fragment {
    private BaseListAdapter<T> baseListAdapter;
    private FragmentActivity fragmentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = getActivity();
    }

    public BaseListAdapter<T> getBaseListAdapter() {
        return baseListAdapter;
    }

    public FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }
}
