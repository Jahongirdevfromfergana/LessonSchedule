package com.example.lessonschedule.screen.menuone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lessonschedule.R
import com.example.lessonschedule.databinding.FragmentMenuOneBinding
import com.example.lessonschedule.model.MoreModel
import com.example.lessonschedule.screen.view.MenuAdapter
import com.example.lessonschedule.screen.view.MenuAdapterCollBack

class MenuOneFragment : Fragment() {
    lateinit var binding: FragmentMenuOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewMore.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMore.adapter = MenuAdapter(listOf(
            MoreModel(R.drawable.img2, "Lorem ipsum"),
            MoreModel(R.drawable.img2, "Lorem ipsum"),
            MoreModel(R.drawable.img1, "Lorem ipsum"),
            MoreModel(R.drawable.img3, "Lorem ipsum"),
            MoreModel(R.drawable.img2, "Lorem ipsum"),
            MoreModel(R.drawable.img2, "Lorem ipsum"),
            MoreModel(R.drawable.img2, "Lorem ipsum"),
            MoreModel(R.drawable.img2, "Lorem ipsum"),
            MoreModel(R.drawable.img2, "Lorem ipsum"),


        ), object : MenuAdapterCollBack{
            override fun onClickItem(item: MoreModel) {

            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MenuOneFragment()
    }
}