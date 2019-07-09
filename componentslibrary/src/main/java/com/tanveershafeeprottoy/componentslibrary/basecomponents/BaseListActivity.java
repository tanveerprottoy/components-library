package com.tanveershafeeprottoy.componentslibrary.basecomponents;


import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class BaseListActivity<T extends BaseListItemModel> extends AppCompatActivity {
    private BaseListAdapter<T> baseListAdapter;

    public BaseListAdapter<T> getBaseListAdapter() {
        return baseListAdapter;
    }
}
