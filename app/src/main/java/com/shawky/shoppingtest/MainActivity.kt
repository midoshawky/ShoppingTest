package com.shawky.shoppingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.hilt.lifecycle.ViewModelInject
import com.shawky.shoppingtest.Servcies.Data.ProductsDataImpl
import com.shawky.shoppingtest.viewModels.MainPageViewModel
import com.shawky.shoppingtest.databinding.ActivityMainBinding
import com.shawky.shoppingtest.viewModels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    lateinit var fragmentsManager : FragmentManager
    lateinit var productsDataImpl: ProductsDataImpl

    private val mainPageViewModel: MainPageViewModel by viewModels()
    private val productsViewModel : ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        fragmentsManager = supportFragmentManager


        binding.navigation.setOnItemSelectedListener { item ->
            mainPageViewModel.navigateFragment(item.itemId,binding.fragmentContainerView.id,fragmentsManager)
            return@setOnItemSelectedListener true
        }

        binding.cartViewModel = productsViewModel


    }
}