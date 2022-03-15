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
import java.lang.String
import javax.inject.Inject
import kotlin.random.Random

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

                return@setOnItemSelectedListener true
            }else{
                mainPageViewModel.navigateFragment(item.itemId,binding.fragmentContainerView.id,fragmentsManager)

            }

        }


        binding.cartViewModel = productsViewModel

    }

    val colors = arrayListOf<kotlin.String>("0096a5","00a51e","0f0f87","69e169","b496b4","d23ce1","f0b42d")
    fun changeTheme(){

//        val red = Random.nextInt(255)
//        val green = Random.nextInt(255)
//        val blue = Random.nextInt(255)
//        val hex = String.format("%02x%02x%02x", red,green,blue)
//        Log.i("Color","Color $hex")

        val random = Random.nextInt(colors.size)

        val newTheme = resources.getIdentifier("T_" + colors[random], "style", packageName)
        mainPageViewModel.theme.value = newTheme
        recreate()
    }
}