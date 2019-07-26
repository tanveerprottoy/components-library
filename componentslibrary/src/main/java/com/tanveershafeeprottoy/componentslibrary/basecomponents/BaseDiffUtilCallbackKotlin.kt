package com.tanveershafeeprottoy.componentslibrary.basecomponents

import androidx.recyclerview.widget.DiffUtil

/**
 * @author Tanveer Shafee Prottoy
 */
class BaseDiffUtilCallbackKotlin<T : BaseListItemModelKotlin>(
    private val oldItemList: List<T>?,
    private val newItemList: List<T>?
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldItemList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newItemList?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            oldItemList!![oldItemPosition].id == newItemList!![newItemPosition].id
        }
        catch(n: NullPointerException) {
            false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return try {
            oldItemList!![oldItemPosition] == newItemList!![newItemPosition]
        }
        catch(n: NullPointerException) {
            false
        }
    }
}