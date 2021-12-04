package com.shawky.shoppingtest.Utils

import android.util.Log
import com.shawky.shoppingtest.Models.ProductModel
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import javax.inject.Inject


class HttpHandling @Inject constructor(val client : HttpClient) {
    suspend fun getRequest(url : String , paras : HashMap<*,*>?) : List<*> {
        return  try {
            client.get {
                url(url)
            }
        }
        catch (e:Exception){
            Log.i("ResponseErr" , " Err : ${e.message}")
            return emptyList<Any>()
        }
    }
}