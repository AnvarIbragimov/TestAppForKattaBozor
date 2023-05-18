package com.example.testappforkattabozor.ui.product

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappforkattabozor.data.api.ApiResult
import com.example.testappforkattabozor.data.api.BaseApiResponse
import com.example.testappforkattabozor.data.repository.ProductRepository
import com.example.testappforkattabozor.data.models.BaseProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    application: Application,
    private val productRepository: ProductRepository
) : AndroidViewModel(application) {

    private val _products: MutableLiveData<ApiResult<BaseProductData>> = MutableLiveData()
    val products: MutableLiveData<ApiResult<BaseProductData>> = _products

    fun getOffers() {
        viewModelScope.launch {
            productRepository.getOffers().collect { data ->
                _products.value = data
            }
        }
    }
}