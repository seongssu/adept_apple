package com.android.newsreaderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.android.newsreaderapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    lateinit var tabLayout: TabLayout
    private lateinit var titleFragment: TitleFragment
    private lateinit var detailFragment: DetailFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        tabLayout = binding.mainTabLayout
        titleFragment = TitleFragment()
        detailFragment = DetailFragment()

        val fragmentManager = supportFragmentManager
        val screen:FragmentTransaction = fragmentManager.beginTransaction()
        screen.add(R.id.main_FramLayout, titleFragment, "TitleFragment")
        screen.add(R.id.main_FramLayout, detailFragment, "DetailFragment")
        screen.hide(detailFragment)
        screen.commit()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                val screen = supportFragmentManager.beginTransaction()

                when(tab.position){
                    0 -> {
                        screen.show(titleFragment)
                        screen.hide(detailFragment)
                    }
                    1 -> {
                        screen.show(detailFragment)
                        screen.hide(titleFragment)
                    }
                }
                screen.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        }
        )

    }
}