package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.view.View;

/**
 * @author Tanveer Shafee Prottoy
 */
public interface ListItemOnClickListener {

    void onItemClick(int adapterPosition, View view);

    boolean onItemLongClick(int adapterPosition, View view);
}
