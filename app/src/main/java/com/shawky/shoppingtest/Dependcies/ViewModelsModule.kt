package com.shawky.shoppingtest.Dependcies

import com.shawky.shoppingtest.Servcies.Data.ProductsDataImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelsModule {

    @Singleton
    @Provides
    fun getProductData(client: HttpClient) : ProductsDataImpl {
        return  ProductsDataImpl(client = client)
    }
}