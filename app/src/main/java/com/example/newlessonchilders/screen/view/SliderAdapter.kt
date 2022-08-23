package com.example.newlessonchilders.screen.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.newlessonchilders.R
import com.example.newlessonchilders.SliderItem
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter internal constructor(sliderItems: MutableList<SliderItem>, viewPager2: ViewPager2):
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>(){

    private val sliderItems: List<SliderItem>
    private val viewPager2: ViewPager2

    init {
        this.sliderItems = sliderItems
        this.viewPager2 = viewPager2
    }

    class SliderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageView: RoundedImageView = itemView.findViewById(R.id.image_slider)

        fun image(sliderItem: SliderItem){
            imageView.setImageResource(sliderItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slide_item_container, parent, false)
        )
    }
    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.image(sliderItems[position])
        if (position == sliderItems.size  - 1){
            viewPager2.post(runnable)
        }
    }
    override fun getItemCount(): Int = sliderItems.size
    private val runnable = Runnable {
        sliderItems.addAll(sliderItems)
        notifyDataSetChanged()
    }
}
