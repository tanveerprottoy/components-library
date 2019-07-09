package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class BaseDiffUtilCallback<T extends BaseListItemModel> extends DiffUtil.Callback {
    private List<T> oldItemList;
    private List<T> newItemList;

    public BaseDiffUtilCallback(
        List<T> oldItemList,
        List<T> newItemList
    ) {
        this.oldItemList = oldItemList;
        this.newItemList = newItemList;
    }

    @Override
    public int getOldListSize() {
        return oldItemList.size();
    }

    @Override
    public int getNewListSize() {
        return newItemList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemList.get(oldItemPosition).getId() == newItemList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemList.get(oldItemPosition).equals(newItemList.get(newItemPosition));
    }
}
