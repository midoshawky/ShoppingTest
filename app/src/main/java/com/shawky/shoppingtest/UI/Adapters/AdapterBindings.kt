package com.shawky.shoppingtest.UI.Adapters

import android.content.Intent
import android.view.View
import com.shawky.shoppingtest.Models.ProductModel
import com.shawky.shoppingtest.databinding.ProductItemViewBinding
import com.shawky.shoppingtest.databinding.SectionLayoutBinding
import com.shawky.shoppingtest.databinding.SectionRvItemBinding

object AdapterBindings {

    fun bindingInterface() : GenericSimpleRecyclerBindingInterface<ProductModel> {
        return object : GenericSimpleRecyclerBindingInterface<ProductModel> {
            override fun bindData(item: ProductModel, view: View) {
                val adapterBinding = ProductItemViewBinding.bind(view)
                adapterBinding.title.text = item.title
                adapterBinding.category.text = item.category
                adapterBinding.description.text = item.description
                adapterBinding.price.text = item.price.toString()
            }
        }
    }

    fun bindingInterface2() : GenericSimpleRecyclerBindingInterface<Int> {
        return object : GenericSimpleRecyclerBindingInterface<Int> {
            override fun bindData(item: Int, view: View) {
                val adapterBinding = SectionRvItemBinding.bind(view)
                adapterBinding.imageView4.setImageResource(item)
            }
        }
    }
    val onPressedInterface2 =
        object : OnPressedInterface<Int> {
            override fun onPressed(item: Any) {

            }

        }
    private val onPressedInterface =
        object : OnPressedInterface<ProductModel> {
            override fun onPressed(item: Any) {

            }

        }
}