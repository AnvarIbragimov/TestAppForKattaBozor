package com.example.testappforkattabozor.data.api

import com.example.testappforkattabozor.data.models.BaseProductData
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("test/api/v1/offers")
    suspend fun getOffers(): Response<BaseProductData>
}