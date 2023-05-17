package com.example.testappforkattabozor.dynamic_views

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.testappforkattabozor.databinding.VerticalViewBinding
import com.example.testappforkattabozor.models.ProductAttributesData

class VerticalView(context: Context) : LinearLayout(context) {

    private lateinit var binding: VerticalViewBinding

    constructor(context: Context, attribute: ProductAttributesData):this(context){
        binding = VerticalViewBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)

        binding.tvTitle.text = attribute.name ?: ""
        binding.tvValue.text = attribute.value ?: ""
    }

}