package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents.BaseListAdapter;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class BaseListActivity<T> extends AppCompatActivity {
    protected BaseListAdapter<T> baseListAdapter;
}
