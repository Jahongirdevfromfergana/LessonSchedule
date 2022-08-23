package com.example.newlessonchilders.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.newlessonchilders.R
import com.example.newlessonchilders.databinding.ActivityProfileBinding
import com.example.newlessonchilders.screen.category.CategoryFragment
import com.example.newlessonchilders.screen.home.HomeFragment
import com.example.newlessonchilders.screen.profile.ProfileFragment
import com.example.newlessonchilders.screen.store.StoreFragment

class ProfileActivity : AppCompatActivity() {
    val homeFragment = HomeFragment.newInstance()
    val categoryFragment = CategoryFragment.newInstance()
    val storeFragment = StoreFragment.newInstance()
    val profileFragment = ProfileFragment.newInstance()
    var activeFragment: Fragment = homeFragment

//    val VIDEO_ID = "YuGih9B5kMs"
//    val YOUTUBE_API ="AIzaSyAh5AAvzmQBC8Nge841ATv4hCxPiizJLCM"
//z
//    private lateinit var youtubePlayer: YouTubePlayerView
//    private lateinit var btnPlay: Button
//
//    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener


    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        youtubePlayer = binding.youtubePlayer
//        btnPlay = binding.btnPlay

//        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubePlayer?,
//                p2: Boolean
//            ) {
//                p1?.loadVideo(VIDEO_ID)
//            }
//
//            override fun onInitializationFailure(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubeInitializationResult?
//            ) {
//                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//        btnPlay.setOnClickListener {
//            youtubePlayer.initialize(YOUTUBE_API, youtubePlayerInit)
//        }

        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, homeFragment, homeFragment.tag)
            .hide(homeFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, categoryFragment, categoryFragment.tag)
            .hide(categoryFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, storeFragment, storeFragment.tag)
            .hide(storeFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, profileFragment, profileFragment.tag)
            .hide(profileFragment)
            .commit()
        supportFragmentManager.beginTransaction().show(activeFragment).commit()

        binding.bottomNavigation.setOnItemSelectedListener {
            if (it.itemId == R.id.actionHome) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment).show(homeFragment)
                    .commit()
                binding.toolbar.visibility = View.VISIBLE
                activeFragment = homeFragment
            } else if (it.itemId == R.id.actionCategory) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(categoryFragment).commit()
                binding.toolbar.visibility = View.VISIBLE
                activeFragment = categoryFragment
            } else if (it.itemId == R.id.actionStore) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(storeFragment)
                    .commit()
                binding.toolbar.visibility = View.VISIBLE
                activeFragment = storeFragment
            } else if (it.itemId == R.id.actionUser) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(profileFragment).commit()
                binding.toolbar.visibility = View.GONE
                activeFragment = profileFragment
            }
            return@setOnItemSelectedListener true
        }


    }
}