package com.example.itunesapiassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.itunesapiassignment.model.remote.TERM_CLASSIC
import com.example.itunesapiassignment.model.remote.TERM_POP
import com.example.itunesapiassignment.model.remote.TERM_ROCK
import com.example.itunesapiassignment.view.MusicFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {

        private lateinit var viewPager: ViewPager2
        private lateinit var tabLayout: TabLayout

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            viewPager = findViewById(R.id.view_pager)

            val pagerAdapter = ScreenSlidePagerAdapter(this)
            viewPager.adapter = pagerAdapter

            tabLayout = findViewById(R.id.tab_layout)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = TERM_ROCK
                        tab.icon = getDrawable(R.drawable.ic_baseline_home_24)
                    }
                    2 -> {
                        tab.text = TERM_POP
                        tab.icon = getDrawable(R.drawable.ic_baseline_notifications_24)
                    }
                    else -> {
                        tab.text = TERM_CLASSIC
                        tab.icon = getDrawable(R.drawable.ic_baseline_dashboard_24)
                    }
                }
            }.attach()
        }

        override fun onBackPressed() {
            if (viewPager.currentItem == 0) {
                super.onBackPressed()
            } else {
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }

        private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
            override fun getItemCount(): Int = NUM_PAGES

            override fun createFragment(position: Int): Fragment {
                val frag = MusicFragment()
                frag.newInstance(position)
                return frag
            }
        }
    }
