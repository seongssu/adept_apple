package com.android.latecomers


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.android.latecomers.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var tabLayout: TabLayout
    private lateinit var mainFragment: MainFragment
    private lateinit var favoritesFragment: FavoritesFragment
    private lateinit var currentFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        tabLayout = binding.tabLayout
        mainFragment = MainFragment()
        favoritesFragment = FavoritesFragment()
//        currentFragment = mainFragment

//        val viewPager = binding.viewPager

        val fragmentManager = supportFragmentManager
        val screen: FragmentTransaction = fragmentManager.beginTransaction()
        screen.add(R.id.fragmentView, mainFragment, "MainFragment")
        screen.add(R.id.fragmentView, favoritesFragment, "FavoritesFragment")
        screen.hide(favoritesFragment)
        screen.commit()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val screen = supportFragmentManager.beginTransaction()

                when (tab.position) {
                    0 -> {
                        screen.show(mainFragment)
                        screen.hide(favoritesFragment)
                    }
                    1 -> {
                        screen.show(favoritesFragment)
                        screen.hide(mainFragment)
                    }
                }

                screen.commit()
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        }
        )
    }
}

