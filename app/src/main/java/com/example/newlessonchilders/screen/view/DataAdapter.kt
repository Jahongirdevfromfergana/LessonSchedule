package com.example.newlessonchilders.screen.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newlessonchilders.R

class DataAdapter(private var items : MutableList<String>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.item.text = items[index]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.more_item_layout, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.titleMore)
    }
}










































//interface MoreAdapterCallback{
//
//    fun onClickItem(item: MoreModel)
//}

//class MoreAdapter(val items: List<MoreModel>): RecyclerView.Adapter<MoreAdapter.ItemHolder>() {
//
//
//    var itemModelList = ArrayList<MoreModel>()
//
//    fun setData(itemModelList: ArrayList<MoreModel>){
//        this.itemModelList.size
//    }
//
//
//
//    inner class ItemHolder(val binding: MoreItemLayoutBinding): RecyclerView.ViewHolder(binding.root)
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
//        return ItemHolder(MoreItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
//        val itemModel = items[position]
//
////        holder.itemView.setOnClickListener {
////            callback.onClickItem(itemModel)
////
////        }
//        holder.binding.imageview.setImageResource(itemModel.image)
//        holder.binding.titleMore.text  = itemModel.title
//
//    }
//
//    override fun getItemCount(): Int = itemModelList.count()
//
//
//    class ItemsAdapter(itemView: View): RecyclerView.ViewHolder(itemView){
//
//    }
//}