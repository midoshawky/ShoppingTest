package com.shawky.shoppingtest.UI.Fragments.MainPageScreens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shawky.shoppingtest.Models.ProductModel
import com.shawky.shoppingtest.R
import com.shawky.shoppingtest.UI.Adapters.ProductRVAdapter
import com.shawky.shoppingtest.viewModels.ProductsViewModel
import com.shawky.shoppingtest.databinding.FragmentHomeScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.*
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.fragment_home_screen) {

    private var binding : FragmentHomeScreenBinding ?=null
    lateinit var productAdapter : ProductRVAdapter
    private var productsList : MutableList<ProductModel> = listOf<ProductModel>().toMutableList()
    private val model: ProductsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        productAdapter = ProductRVAdapter(productsList,
            { productModel , image ->


            }) {product ->
            Log.i("Order","Product : ${product.id}")
            model.addItemsToCart(product)
        }

        binding!!.productsRv.adapter = productAdapter
        binding!!.productsRv.layoutManager = LinearLayoutManager(requireContext())


        model.products.observe(requireActivity()){ products ->
            binding!!.progressBar.visibility = View.GONE
            productsList.addAll(products)
            Log.i("Products" , "products here : $productsList")
            productAdapter.notifyDataSetChanged()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}