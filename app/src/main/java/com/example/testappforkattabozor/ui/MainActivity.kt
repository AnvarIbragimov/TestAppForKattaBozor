package com.example.testappforkattabozor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testappforkattabozor.R
import com.example.testappforkattabozor.databinding.ActivityMainBinding
import com.example.testappforkattabozor.ui.product.ProductsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = ProductsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitAllowingStateLoss()
    }
}