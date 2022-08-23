package com.example.newlessonchilders.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.newlessonchilders.databinding.ActivitySelectedBinding

class SelectedActivity : AppCompatActivity() {

    lateinit var tvSelected: TextView
    lateinit var binding: ActivitySelectedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        initData()
    }
//    private fun initData(){
//        tvSelected = binding.tvSelected
//        getData()
//    }
//    private fun getData(){
//        var intent = intent.extras
//
//        var postName = intent!!.getString("postname")
//
//        tvSelected.text = postName
//    }
}