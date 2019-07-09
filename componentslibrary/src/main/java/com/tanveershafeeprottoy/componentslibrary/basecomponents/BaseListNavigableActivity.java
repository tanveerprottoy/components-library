package com.tanveershafeeprottoy.componentslibrary.basecomponents;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class BaseListNavigableActivity<T extends BaseListItemModel>
    extends BaseNavigableActivity {
    private BaseListAdapter<T> baseListAdapter;

    public BaseListAdapter<T> getBaseListAdapter() {
        return baseListAdapter;
    }
}
