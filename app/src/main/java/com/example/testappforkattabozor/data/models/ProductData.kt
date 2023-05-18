package com.example.testappforkattabozor.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseProductData(
    @SerializedName("offers") val offers: ArrayList<ProductData>? = null,
) : Serializable

data class ProductData(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("brand") val brand: String? = null,
    @SerializedName("category") val category: String? = null,
    @SerializedName("merchant") val merchant: String? = null,
    @SerializedName("attributes") val attributes: ArrayList<ProductAttributesData>? = null,
    @SerializedName("image") val image: ProductImageData? = null,
    var isExpanded: Boolean = false,
) : Serializable

data class ProductAttributesData(
    @SerializedName("name") val name: String? = null,
    @SerializedName("value") val value: String? = null,
) : Serializable


data class ProductImageData(
    @SerializedName("width") val width: Int? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("url") val url: String? = null,
) : Serializable
