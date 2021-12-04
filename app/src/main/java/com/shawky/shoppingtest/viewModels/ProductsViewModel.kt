package com.shawky.shoppingtest.viewModels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shawky.shoppingtest.Dependcies.AppModule
import com.shawky.shoppingtest.Models.ProductModel
import com.shawky.shoppingtest.Servcies.Data.ProductsDataImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ProductsViewModel @Inject constructor(private  val productsDataImpl: ProductsDataImpl): ViewModel() {
    private val productsList : MutableLiveData<List<ProductModel>> = MutableLiveData()
    val products : LiveData<List<ProductModel>> = productsList
    private val cartItemsList : ArrayList<ProductModel> = ArrayList()
    private val cartItems : MutableLiveData<ArrayList<ProductModel>> = MutableLiveData()
    val cartItemsCount :MutableLiveData<String> = MutableLiveData("0")
    //

    init {
        viewModelScope.launch {
            val data = productsDataImpl.getAllProducts()
            Log.i("Products","View model producr : $data")
            delay(1000)
            productsList.value = data
        }

    }

    fun addItemsToCart(productModel: ProductModel){
        cartItemsList.add(productModel)
        cartItems.value = cartItemsList
        cartItemsCount.postValue(cartItemsList.size.toString())
    }
}