package com.android.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.apple.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
        setContentView(binding.root)

    }
}