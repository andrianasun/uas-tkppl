package com.example.tkppl_uas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = HomeFragment()
        val watchVideo = WatchVideoFragment()
        val notification = NotificationFragment()
        val account = AccountFragment()

        makeCurrentFragment(home)
        navigation_bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemHome -> makeCurrentFragment(home)
                R.id.itemWatchVideo -> makeCurrentFragment(watchVideo)
                R.id.itemNotification -> makeCurrentFragment(notification)
                R.id.itemAccount -> makeCurrentFragment(account)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.container, fragment, fragment::class.java.simpleName)
            .commit()
    }

}