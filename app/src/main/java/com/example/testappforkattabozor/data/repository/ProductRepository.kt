package com.example.testappforkattabozor.data.repository

import com.example.testappforkattabozor.data.api.ApiResult
import com.example.testappforkattabozor.data.api.BaseApiResponse
import com.example.testappforkattabozor.data.api.ProductApi
import com.example.testappforkattabozor.data.models.BaseProductData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productApi: ProductApi
) : BaseApiResponse() {

    suspend fun getOffers(): Flow<ApiResult<BaseProductData>> {
        return flow {
            emit(safeApiCall { productApi.getOffers() })
        }.flowOn(Dispatchers.IO)
    }

}