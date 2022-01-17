package com.shawky.shoppingtest.UI.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shawky.shoppingtest.Models.ProductModel
import com.shawky.shoppingtest.R
import com.shawky.shoppingtest.databinding.SectionLayoutBinding

class SectionAdapter(
    private val fragment:Fragment,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class NewsSectionViewHolder(private val binding: SectionLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val rvAdapter = GenericRecyclerAdapter<Int>(
                arrayListOf<Int>(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background),
                R.layout.section_rv_item,
                AdapterBindings.bindingInterface2(),
                AdapterBindings.onPressedInterface2
            )
            binding.apply {
                sectionName.text = "News"
                rv.apply {
                    adapter = rvAdapter
                    layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
                }
            }
        }
    }

    inner class ReviewsSectionViewHolder(private val binding: SectionLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind2() {
            val rvAdapter = GenericRecyclerAdapter<Int>(
                arrayListOf<Int>(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background),
                R.layout.section_rv_item,
                AdapterBindings.bindingInterface2(),
                AdapterBindings.onPressedInterface2
            )
            binding.apply {
                sectionName.text = "Reviews"
                rv.apply {
                    adapter = rvAdapter
                    layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when  {
            viewType%2 == 0 -> {
                val binding = SectionLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NewsSectionViewHolder(binding)
            }
            viewType%2 == 1 -> {
                val binding = SectionLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ReviewsSectionViewHolder(binding)
            }
            else -> {
                val binding = SectionLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NewsSectionViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            position%2 == 0 ->{
                val sectionHolder : NewsSectionViewHolder = holder as NewsSectionViewHolder
                sectionHolder.bind()
            }
            position%2 == 1 ->{
                val reviewsHolder : ReviewsSectionViewHolder = holder as ReviewsSectionViewHolder
                reviewsHolder.bind2()
            }
            else ->{}
        }
    }

    override fun getItemCount(): Int = 10
}