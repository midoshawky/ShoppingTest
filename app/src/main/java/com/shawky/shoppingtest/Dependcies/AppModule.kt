package com.shawky.shoppingtest.Dependcies

import com.shawky.shoppingtest.Utils.HttpHandling
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun initializeClient() : HttpClient
    {
        return HttpClient(Android){
            install(Logging){
                level = LogLevel.ALL
            }
            install(JsonFeature){
                serializer = KotlinxSerializer()
            }
        }
    }
}