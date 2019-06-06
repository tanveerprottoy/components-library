package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] titleArray;
    private Fragment[] fragmentArray;

    public BaseFragmentPagerAdapter(
        FragmentManager fragmentManager,
        String[] titleArray,
        Fragment[] fragmentArray
    ) {
        super(fragmentManager);
        this.titleArray = titleArray;
        this.fragmentArray = fragmentArray;
    }

    @Override
    @NonNull
    public Fragment getItem(int position) {
        return fragmentArray[position];
    }

    @Override
    public int getCount() {
        return fragmentArray.length;
    }

    @Override
    @Nullable
    public CharSequence getPageTitle(int position) {
        return titleArray[position];
    }
}
