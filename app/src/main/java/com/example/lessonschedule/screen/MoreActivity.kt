package com.example.lessonschedule.screen

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonschedule.R


class MoreActivity : AppCompatActivity() {
    var searchView: SearchView? = null
    var listView: ListView? = null
    var adapter: ArrayAdapter<*>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.listView)

//        list.add("Orange")
//        list.add("Mango")
//        list.add("Grapes")
//        list.add("Lemon")
//        list.add("Melon")
//        list.add("Watermelon")
//        list.add("Papaya")

    }
}