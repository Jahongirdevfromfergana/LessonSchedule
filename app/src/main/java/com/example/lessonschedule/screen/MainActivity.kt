package com.example.lessonschedule.screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lessonschedule.R
import com.example.lessonschedule.databinding.ActivityMainBinding
import com.example.lessonschedule.screen.homeone.HomeOneFragment
import com.example.lessonschedule.screen.likeone.LikeOneFragment
import com.example.lessonschedule.screen.menuone.MenuOneFragment
import com.example.lessonschedule.screen.messageone.MessageOneFragment
import com.example.lessonschedule.screen.notifione.NotificationOneFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    val homeOneFragment = HomeOneFragment.newInstance()
    val menuOneFragment = MenuOneFragment.newInstance()
    val likeOneFragment = LikeOneFragment.newInstance()
    val messageOneFragment = MessageOneFragment.newInstance()
    val notificationOneFragment = NotificationOneFragment.newInstance()
    var activeFragment: Fragment = homeOneFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.navProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))

        }
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_call -> Toast.makeText(applicationContext, "OOOOOOOOO", Toast.LENGTH_LONG).show()
                R.id.nav_about -> Toast.makeText(applicationContext, "OOOOOOOOO", Toast.LENGTH_LONG).show()
            }
            true
        }
        binding.navView.bringToFront()
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportFragmentManager.beginTransaction()
            .add(R.id.flContainerOne, homeOneFragment, homeOneFragment.tag)
            .hide(homeOneFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainerOne, menuOneFragment, menuOneFragment.tag)
            .hide(menuOneFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainerOne, notificationOneFragment, notificationOneFragment.tag)
            .hide(notificationOneFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainerOne, likeOneFragment, likeOneFragment.tag)
            .hide(likeOneFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainerOne, messageOneFragment, messageOneFragment.tag)
            .hide(messageOneFragment)
            .commit()
        supportFragmentManager.beginTransaction().show(activeFragment).commit()

        binding.bottomNavigationOne.setOnItemSelectedListener {
            if (it.itemId == R.id.actionOneHome) {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(homeOneFragment)
                    .commit()
                activeFragment = homeOneFragment
            } else if (it.itemId == R.id.actionOneMenu) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(menuOneFragment).commit()
                activeFragment = menuOneFragment
            } else if (it.itemId == R.id.actionOneNotification) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(notificationOneFragment).commit()
                activeFragment = notificationOneFragment
            } else if (it.itemId == R.id.actionOneFavorite) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(likeOneFragment).commit()
                activeFragment = likeOneFragment
            } else if (it.itemId == R.id.actionOneMessage) {
                supportFragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(messageOneFragment).commit()
                activeFragment = messageOneFragment
            }
            return@setOnItemSelectedListener true
        }
    }
}