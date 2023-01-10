package com.example.lessonschedule.screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonschedule.databinding.MenuItemLayoutBinding
import com.example.lessonschedule.model.MoreModel


interface MenuAdapterCollBack{
    fun onClickItem(item: MoreModel)
}

class MenuAdapter(val items: List<MoreModel>, val callback: MenuAdapterCollBack): RecyclerView.Adapter<com.example.lessonschedule.screen.view.MenuAdapter.ItemHolder>() {
    inner class  ItemHolder(val binding: MenuItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(MenuItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClickItem(item)
        }
        holder.binding.imageMenu.setImageResource(item.image)
        holder.binding.titleMenu.text = item.title
    }
    override fun getItemCount(): Int = items.count()
}