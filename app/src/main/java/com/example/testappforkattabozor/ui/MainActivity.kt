package com.example.testappforkattabozor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappforkattabozor.adapters.ProductsAdapter
import com.example.testappforkattabozor.databinding.ActivityMainBinding
import com.example.testappforkattabozor.models.BaseProductData
import com.example.testappforkattabozor.models.ProductData
import com.example.testappforkattabozor.utils.Utils
import com.example.testappforkattabozor.utils.productJson
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { ProductsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initAdapter()
    }

    private fun initAdapter() {
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = adapter
        adapter.setData(getProductList())
    }

    private fun getProductList(): ArrayList<ProductData> {
        val jsonFileString = Utils.getJsonFromAssets(applicationContext, productJson)
        val baseProduct = Gson().fromJson(jsonFileString, BaseProductData::class.java)
        return baseProduct.offers ?: arrayListOf()
    }
}