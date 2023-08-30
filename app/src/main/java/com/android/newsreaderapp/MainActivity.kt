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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = binding.mainTabLayout
        titleFragment = TitleFragment()

        val fragmentManager = supportFragmentManager
        val screen:FragmentTransaction = fragmentManager.beginTransaction()
        screen.add(R.id.main_FramLayout, titleFragment, "TitleFragment")
        screen.commit()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                val screen = supportFragmentManager.beginTransaction()

                when(tab.position){
                    0 -> {
                        screen.show(titleFragment)
                    }

                }
                screen.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        }
        )

    }
}