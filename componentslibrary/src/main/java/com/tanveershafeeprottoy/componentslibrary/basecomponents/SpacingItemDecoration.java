package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceLeft, spaceRight, spaceTop, spaceBottom;

    public SpacingItemDecoration(
        int spaceLeft,
        int spaceRight,
        int spaceTop,
        int spaceBottom
    ) {
        this.spaceLeft = spaceLeft;
        this.spaceRight = spaceRight;
        this.spaceTop = spaceTop;
        this.spaceBottom = spaceBottom;
    }

    @Override
    public void getItemOffsets(
        @NonNull Rect outRect,
        @NonNull View view,
        @NonNull RecyclerView parent,
        @NonNull RecyclerView.State state
    ) {
        outRect.left = spaceLeft;
        outRect.right = spaceRight;
        outRect.bottom = spaceBottom;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildLayoutPosition(view) == 0) {
            outRect.top = spaceTop;
        }
        else {
            outRect.top = 0;
        }
    }
}
