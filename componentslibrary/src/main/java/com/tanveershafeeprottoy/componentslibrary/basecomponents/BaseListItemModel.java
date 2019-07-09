package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import androidx.annotation.Nullable;

public class BaseListItemModel {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == null) {
            return false;
        }
        if(!BaseListItemModel.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        return id == ((BaseListItemModel) obj).getId();
    }
}
