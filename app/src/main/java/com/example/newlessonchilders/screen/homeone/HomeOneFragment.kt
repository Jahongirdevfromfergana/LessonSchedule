package com.example.lessonschedule.screen.homeone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.lessonschedule.R
import com.example.lessonschedule.SliderItem
import com.example.lessonschedule.databinding.FragmentHomeOneBinding
import com.example.newlessonchilders.model.CategoryModel
import com.example.newlessonchilders.model.FeaturedModel
import com.example.newlessonchilders.model.PopularModel
import com.example.newlessonchilders.screen.MoreActivity
import com.example.newlessonchilders.screen.ProfileActivity
import com.example.newlessonchilders.screen.feature_item.FeatureItemActivity
import com.example.newlessonchilders.screen.popular_item.PopularItemActivity
import com.example.lessonschedule.screen.view.*
import com.example.newlessonchilders.screen.view.*
import kotlin.math.abs


class HomeOneFragment : Fragment() {
    lateinit var binding: FragmentHomeOneBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var viewPager2: ViewPager2
    var sliderHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeOneBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMenu.setOnClickListener {
            binding.drawerLayoutOne.openDrawer(binding.navView)
        }
        binding.navProfile.setOnClickListener {
            startActivity(Intent(requireActivity(), ProfileActivity::class.java))
        }
        binding.navView.bringToFront()
        toggle = ActionBarDrawerToggle(requireActivity(), binding.drawerLayoutOne, R.string.open, R.string.close)
        binding.drawerLayoutOne.addDrawerListener(toggle)
        toggle.syncState()

        binding.recyclerCategory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerCategory.adapter = CategoryAdapter(
            listOf(
                CategoryModel(R.drawable.img2, "category", 11),
                CategoryModel(R.drawable.img1, "category", 11),
                CategoryModel(R.drawable.img3, "category", 11),
                CategoryModel(R.drawable.img4, "category", 11),
                ), object: CategoryAdapterCallback{
                override fun onClickItem(item: CategoryModel) {
                    startActivity(Intent(requireActivity(), MoreActivity::class.java))
                }
                }
        )
        binding.recyclerPopular.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerPopular.adapter = PopularAdapter(
            listOf(
                PopularModel(R.drawable.img1, "popular"),
                PopularModel(R.drawable.img2, "popular"),
                PopularModel(R.drawable.img3, "popular"),
                PopularModel(R.drawable.img4, "popular"),
                PopularModel(R.drawable.img5, "popular"),
                PopularModel(R.drawable.img1, "popular"),
                PopularModel(R.drawable.img2, "popular"),
                PopularModel(R.drawable.img3, "popular"),
                PopularModel(R.drawable.img4, "popular"),
                PopularModel(R.drawable.img5, "popular"),

                ), object: PopularAdapterCollBack{
                override fun onClickItem(item: PopularModel) {
                    startActivity(Intent(requireActivity(), PopularItemActivity::class.java))
                }

            }
        )
        binding.recyclerFeatured.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerFeatured.adapter = FeaturedAdapter(
            listOf(
                FeaturedModel(R.drawable.img1, "Features"),
                FeaturedModel(R.drawable.img2, "Features"),
                FeaturedModel(R.drawable.img3, "Features"),
                FeaturedModel(R.drawable.img4, "Features"),
                FeaturedModel(R.drawable.img5, "Features"),
                FeaturedModel(R.drawable.img1, "Features"),
                FeaturedModel(R.drawable.img2, "Features"),
                FeaturedModel(R.drawable.img3, "Features"),
                FeaturedModel(R.drawable.img4, "Features"),
                FeaturedModel(R.drawable.img5, "Features"),
                ), object : FeaturesAdapterCallback{
                override fun onClickItem(item: FeaturedModel) {
                    startActivity(Intent(requireActivity(), FeatureItemActivity::class.java))
                }
            }
        )
        viewPager2 = binding.viewPagerImageSlider
        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.img5))
        sliderItems.add(SliderItem(R.drawable.img1))
        sliderItems.add(SliderItem(R.drawable.img2))

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)

        viewPager2.clipToPadding = false

        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(0))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.00f + r * 1.00f
        }
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
//        binding.search.setOnClickListener {
//            startActivity(Intent(requireActivity(), MainActivity::class.java))
//        }
//        binding.btnMore.setOnClickListener {
//            startActivity(Intent(requireContext(), MoreActivity::class.java))
//        }
    }
    private val sliderRunnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    companion object {
        @JvmStatic
        fun newInstance() = HomeOneFragment()
    }
}