package com.tanveershafeeprottoy.componentslibrary.basecomponents

import androidx.appcompat.app.AppCompatActivity

/**
 * @author Tanveer Shafee Prottoy
 */
abstract class BaseListActivityKotlin<T : BaseListItemModelKotlin> : AppCompatActivity() {
    lateinit var baseListAdapterKotlin: BaseListAdapterKotlin<T>
}