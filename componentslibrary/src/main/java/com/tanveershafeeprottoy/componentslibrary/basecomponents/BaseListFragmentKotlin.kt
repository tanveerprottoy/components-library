package com.tanveershafeeprottoy.componentslibrary.basecomponents

import androidx.fragment.app.Fragment

/**
 * @author Tanveer Shafee Prottoy
 */
abstract class BaseListFragmentKotlin<T : BaseListItemModelKotlin> : Fragment() {
    lateinit var baseListAdapterKotlin: BaseListAdapterKotlin<T>
}