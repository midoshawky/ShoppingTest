package com.shawky.shoppingtest.UI.Fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shawky.shoppingtest.R
import com.shawky.shoppingtest.databinding.ProductItemViewBinding

class ProductInfoScreen : Fragment(R.layout.fragment_product_info_screen) {
    private var  binding : ProductItemViewBinding ? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ProductItemViewBinding.bind(view)

        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
