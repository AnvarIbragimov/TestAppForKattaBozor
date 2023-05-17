package com.example.testappforkattabozor.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testappforkattabozor.R
import com.example.testappforkattabozor.adapters.ProductsAdapter.ViewHolder
import com.example.testappforkattabozor.databinding.ItemProductBinding
import com.example.testappforkattabozor.dynamic_views.VerticalView
import com.example.testappforkattabozor.models.ProductData

class ProductsAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val products = mutableListOf<ProductData>()

    private var lastPosition: Int = -1

    inner class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(products[position]) {

                binding.tvMore.setOnClickListener {
                    products[layoutPosition].isExpanded = !products[layoutPosition].isExpanded
                    notifyItemChanged(layoutPosition)
                }

                binding.tvProductName.text = name ?: ""
                binding.tvBrandName.text = brand ?: ""
                binding.tvCategoryName.text = category ?: ""
                binding.tvMerchantName.text = merchant ?: ""

                binding.llAdditional.removeAllViews()
                attributes?.forEach { attr ->
                    binding.llAdditional.addView(VerticalView(binding.root.context, attr))
                }

                binding.tvMore.text = binding.root.context.resources.getString(
                    if (isExpanded) R.string.hide_more else R.string.more_dots
                )

                binding.elProduct.isExpanded = isExpanded

                Glide.with(binding.root.context).load(image?.url).into(binding.ivProductLogo)
            }
        }
        setAnimation(holder.itemView, position)
    }

    override fun getItemCount() = products.size

//    inner class ViewHolder(private val binding: ItemProductBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        init {
//            binding.tvMore.setOnClickListener {
//                products[layoutPosition].isExpanded = !products[layoutPosition].isExpanded
//                notifyItemChanged(layoutPosition)
//            }
//        }
//
//        fun bind(product: ProductData) = with(binding) {
//
//        }
//
//    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(products: ArrayList<ProductData>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    private fun setAnimation(animateView: View, position: Int) {
        if (position > lastPosition) {
            val animation =
                AnimationUtils.loadAnimation(animateView.context, android.R.anim.slide_in_left)
            animateView.startAnimation(animation)
            lastPosition = position
        }
    }
}

fun ViewGroup.inflateView(resId: Int) =
    LayoutInflater.from(context).inflate(resId, this, false)!!