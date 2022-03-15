package com.shawky.shoppingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
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
        mainPageViewModel.changeTheme(this)


        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        fragmentsManager = supportFragmentManager


        binding.navigation.setOnItemSelectedListener { item ->
            if(item.itemId == R.id.home && mainPageViewModel.theme.value == R.style.Theme_ShoppingTestThemeOne){
                mainPageViewModel.theme.value = R.style.Theme_ShoppingTestThemeTwo
                recreate()
                return@setOnItemSelectedListener true
            }else{
                mainPageViewModel.navigateFragment(item.itemId,binding.fragmentContainerView.id,fragmentsManager)

            }


        }

        binding.cartViewModel = productsViewModel


    }
}