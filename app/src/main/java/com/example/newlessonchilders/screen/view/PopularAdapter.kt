package com.example.newlessonchilders.screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newlessonchilders.databinding.PopularItemLayoutBinding
import com.example.newlessonchilders.model.PopularModel

interface PopularAdapterCollBack{
    fun onClickItem(item: PopularModel)
}
class PopularAdapter(val items: List<PopularModel>, val callback: PopularAdapterCollBack): RecyclerView.Adapter<PopularAdapter.ItemHolder>() {
    inner class  ItemHolder(val binding: PopularItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(PopularItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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