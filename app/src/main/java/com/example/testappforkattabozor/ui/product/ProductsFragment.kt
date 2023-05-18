package com.example.testappforkattabozor.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappforkattabozor.ui.adapters.ProductsAdapter
import com.example.testappforkattabozor.data.api.ApiResult
import com.example.testappforkattabozor.databinding.FragmentProductsBinding
import com.example.testappforkattabozor.data.models.ProductData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductsFragment:Fragment() {

    private val viewModel:ProductViewModel by viewModels()

    @Inject
    lateinit var adapter: ProductsAdapter

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeProducts()
        callProducts()

        binding.refreshLayout.setOnRefreshListener {
            callProducts()
        }
    }

    private fun callProducts() = viewModel.getOffers()

    private fun observeProducts(){
        viewModel.products.observe(viewLifecycleOwner){res->
            when(res){
                is ApiResult.Loading->binding.refreshLayout.isRefreshing = true
                is ApiResult.Success->{
                    initAdapter(res.data.offers?: arrayListOf())
                    binding.refreshLayout.isRefreshing = false
                }
                is ApiResult.Error->binding.refreshLayout.isRefreshing = false
            }
        }
    }

    private fun initAdapter(products:ArrayList<ProductData>) {
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter = adapter
        adapter.setData(products)
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}