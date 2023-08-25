package com.android.latecomers


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.latecomers.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var informationLauncher:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        setFragment(MainFragment())

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position

                when (position) {
                    0 -> {
                        setFragment(MainFragment())
                    }

                    1 -> {
                        setFragment(FavoritesFragment())
                    }
                    // ... 그 외 탭 처리 ...
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        }
        )
        informationLauncher = registerForActivityResult(ActivityResultContracts
            .StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val data = it.data
                if(data !=null){

                }
            }
        }
    }
    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragmentView, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}

