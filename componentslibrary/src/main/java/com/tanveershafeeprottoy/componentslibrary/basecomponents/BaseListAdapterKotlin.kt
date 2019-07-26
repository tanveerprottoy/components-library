package com.tanveershafeeprottoy.componentslibrary.basecomponents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Tanveer Shafee Prottoy
 */
open class BaseListAdapterKotlin<T : BaseListItemModelKotlin>(
    private val resourceId: Int,
    private val variableId: Int,
    private val listItemOnClickListener: ListItemOnClickListener
) : RecyclerView.Adapter<BaseRecyclerViewHolder<T>>() {
    var objList: List<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T> {
        return BaseRecyclerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                resourceId,
                parent,
                false
            ),
            variableId,
            listItemOnClickListener
        )
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<T>, position: Int) {
        try {
            holder.bind(objList!![position])
        }
        catch(e: Exception) {

        }

    }

    override fun getItemCount(): Int {
        return try {
            objList!!.size
        }
        catch(n: NullPointerException) {
            0
        }

    }

    fun submitData(objList: List<T>?) {
        val diffResult = DiffUtil.calculateDiff(
            BaseDiffUtilCallbackKotlin(
                this.objList,
                objList
            )
        )
        diffResult.dispatchUpdatesTo(this)
    }
}