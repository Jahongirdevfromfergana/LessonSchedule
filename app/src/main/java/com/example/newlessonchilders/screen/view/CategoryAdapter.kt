package com.example.newlessonchilders.screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newlessonchilders.databinding.CategoryItemLayoutBinding
import com.example.newlessonchilders.model.CategoryModel

interface CategoryAdapterCallback{
    fun onClickItem(item: CategoryModel)
}

class CategoryAdapter(val items: List<CategoryModel>, val  callback: CategoryAdapterCallback): RecyclerView.Adapter<CategoryAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: CategoryItemLayoutBinding): RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
      return ItemHolder(CategoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClickItem(item)

        }
        holder.binding.imgCategory.setImageResource(item.image)
        holder.binding.title.text = item.title

    }

    override fun getItemCount(): Int = items.count()

}