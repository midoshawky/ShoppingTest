package com.shawky.shoppingtest.Servcies.Data

import android.util.Log
import com.shawky.shoppingtest.Dependcies.AppModule
import com.shawky.shoppingtest.Models.ProductModel
import com.shawky.shoppingtest.Utils.HttpHandling
import com.shawky.shoppingtest.Utils.HttpRouts
import dagger.Component
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import javax.inject.Inject

class ProductsDataImpl(val client: HttpClient){

    suspend fun getAllProducts() : List<ProductModel>{
        return   try {
            Log.i("Client" , "Client : $client")
            client.get {
                url(HttpRouts.GET_PRODUCTS_URL)
            }
        }
        catch (e:Exception){
            Log.i("ResponseErr" , " Err : ${e.message}")
            return emptyList()
        }
    }
}