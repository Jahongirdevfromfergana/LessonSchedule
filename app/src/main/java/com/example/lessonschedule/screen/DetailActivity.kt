package com.example.lessonschedule.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessonschedule.R
import com.example.lessonschedule.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.detailCountryText.text = intent.extras!!.getString("passselectedcountry")!!

    }
}