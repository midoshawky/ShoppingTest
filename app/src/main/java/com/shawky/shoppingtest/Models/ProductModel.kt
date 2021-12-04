package com.shawky.shoppingtest.Models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ProductModel(
    val id: Int,
    val title: String,
    val price: Double,
    val category: String,
    val description: String,
    val image: String,
    val rating : JsonObject?,
    val favourite : Boolean = false
)
