package com.shawky.shoppingtest.UI.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.shawky.shoppingtest.Dependcies.GlideApp
import com.shawky.shoppingtest.Models.ProductModel
import com.shawky.shoppingtest.R
import com.shawky.shoppingtest.databinding.ProductItemViewBinding


class ProductRVAdapter(private val dataSet: List<ProductModel> , val onItemPressed : (ProductModel,ImageView) -> Unit , val onBuyItemPressed : (ProductModel) -> Unit)
    : RecyclerView.Adapter<ProductRVAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(product : ProductModel?){

            val titleText = itemView.findViewById<TextView>(R.id.title)
            val categoryTxt = itemView.findViewById<TextView>(R.id.category)
            val descriptionText = itemView.findViewById<TextView>(R.id.description)
            val image = itemView.findViewById<ImageView>(R.id.imageView)
            val priceText = itemView.findViewById<TextView>(R.id.price)
            val favouriteBtn = itemView.findViewById<ToggleButton>(R.id.toggleButton)
            val buyBtn = itemView.findViewById<Button>(R.id.button3)

            image.transitionName = "small_image${product!!.id}"
            //
            titleText.text = product!!.title
            categoryTxt.text = product.category
            descriptionText.text = product.description
            priceText.text = product.price.toString()
            favouriteBtn.isChecked = product.favourite
            //
            GlideApp.with(itemView.context)
                .load(product.image)
                .into(image)
            //
            buyBtn.setOnClickListener{onBuyItemPressed(product)}
            itemView.setOnClickListener {
                onItemPressed(product,image)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = ProductItemViewBinding.inflate(LayoutInflater.from(viewGroup.context)).root
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position])
    }


    override fun getItemId(position: Int): Long {
        return dataSet[position].id.toLong()
    }

    override fun getItemCount() = dataSet.size
}