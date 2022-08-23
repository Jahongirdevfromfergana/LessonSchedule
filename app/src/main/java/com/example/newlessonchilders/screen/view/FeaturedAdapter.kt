package com.example.newlessonchilders.screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newlessonchilders.databinding.FeaturedItemLayoutBinding
import com.example.newlessonchilders.model.FeaturedModel

interface FeaturesAdapterCallback{
    fun onClickItem(item: FeaturedModel)
}
class FeaturedAdapter(val items: List<FeaturedModel>, val callback: FeaturesAdapterCallback): RecyclerView.Adapter<FeaturedAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: FeaturedItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            return ItemHolder(FeaturedItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClickItem(item)
        }
        holder.binding.popularImg.setImageResource(item.image)
        holder.binding.popularTitle.text = item.title
    }
    override fun getItemCount(): Int = items.count()
}