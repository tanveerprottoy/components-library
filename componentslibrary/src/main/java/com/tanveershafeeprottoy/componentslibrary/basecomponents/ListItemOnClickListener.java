package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import android.view.View;

/**
 * @author Tanveer Shafee Prottoy
 */
public interface ListItemOnClickListener {

    void onItemClick(int adapterPosition, View view);

    boolean onItemLongClick(int adapterPosition, View view);
}
