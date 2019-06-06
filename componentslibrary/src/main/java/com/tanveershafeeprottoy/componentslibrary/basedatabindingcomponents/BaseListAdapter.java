package com.tanveershafeeprottoy.componentslibrary.basedatabindingcomponents;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tanveershafeeprottoy.componentslibrary.basecomponents.BaseRecyclerViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseListAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder<T>> {
    private int resourceId;
    private int variableId;
    private ListItemOnClickListener listItemOnClickListener;
    @Nullable
    protected List<T> objList;

    public BaseListAdapter(
        int resourceId,
        int variableId,
        ListItemOnClickListener listItemOnClickListener
    ) {
        this.resourceId = resourceId;
        this.variableId = variableId;
        this.listItemOnClickListener = listItemOnClickListener;
    }

    @Override
    @NonNull
    public BaseRecyclerViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseRecyclerViewHolder<>(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                resourceId,
                parent,
                false
            ), variableId,
            listItemOnClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder<T> holder, int position) {
        try {
            holder.bind(objList.get(position));
        }
        catch(Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        try {
            return objList.size();
        }
        catch(NullPointerException n) {
            return 0;
        }
    }

    @Nullable
    public List<T> getData() {
        return objList;
    }

    public void setData(@Nullable List<T> objList) {
        this.objList = objList;
        notifyDataSetChanged();
    }
}
