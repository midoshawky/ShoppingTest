package com.shawky.shoppingtest.UI.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import  com.shawky.shoppingtest.R

class GenericRecyclerAdapter<T :Any>(
    val dataSet: ArrayList<T>, @LayoutRes val layoutID: Int,
    private val bindingInterface: GenericSimpleRecyclerBindingInterface<T>,
    private val onItemPressedCallBack : OnPressedInterface<T>
) : RecyclerView.Adapter<GenericRecyclerAdapter<T>.ViewHolder>() {
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun <T : Any> bind(
            item: T,
            bindingInterface: GenericSimpleRecyclerBindingInterface<T>
        ) {
            bindingInterface.bindData(item, view)

            view.setOnClickListener {
                Log.i("Item","View Clicked")
                onItemPressedCallBack.onPressed(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutID, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item,bindingInterface)
    }

    override fun getItemCount(): Int = dataSet.size
}


interface GenericSimpleRecyclerBindingInterface<T:Any> {
    fun bindData(item: T,view:View)
}

interface OnPressedInterface<T:Any> {
    fun onPressed(item: Any)
}
