package com.tanveershafeeprottoy.componentslibrary.basecomponents;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BasePagedListAdapter<T> { /*extends PagedListAdapter<T, BaseRecyclerViewHolder<T>> {

    public BasePagedListAdapter(
        private val resourceId:Int,
        private val variableId:Int,
        private val listItemOnClickListener:ListItemOnClickListener
    ) {


        override fun onCreateViewHolder(
            parent:ViewGroup,
            viewType:Int
    ):BaseRecyclerViewHolder<ConversationDataResponse> {
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

        override fun onBindViewHolder(
            holder:BaseRecyclerViewHolder<ConversationDataResponse>,
        position:
        Int
    ){
            try {
                holder.bind(getItem(position))
            }
            catch(e:Exception){

            }
        }

        companion object {
            *//**
 * This diff callback informs the PagedListAdapter how to compute list differences when new
 * PagedLists arrive.
 * <p>
 * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
 * detect there's only a single item difference from before, so it only needs to animate and
 * rebind a single view.
 *//*
            private val diffCallback =
                object :DiffUtil.ItemCallback<ConversationDataResponse> () {

                override fun areItemsTheSame(
                    oldItem:ConversationDataResponse,
                    newItem:ConversationDataResponse
                ):Boolean = oldItem.id == newItem.id

                *//**
 * Note that in kotlin, == checking on data classes compares all contents, but in Java,
 * typically you'll implement Object#equals, and use it to compare object contents.
 *//*
                override fun areContentsTheSame(
                    oldItem:ConversationDataResponse,
                    newItem:ConversationDataResponse
                ):Boolean = oldItem == newItem
            }
        }
    }*/
}
