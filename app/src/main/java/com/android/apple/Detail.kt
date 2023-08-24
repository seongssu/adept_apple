package com.android.apple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apple.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
        setContentView(binding.root)

        val item = intent.getParcelableExtra<Item>("item")
        Log.d("Detail item", item.toString())

        if (item != null ) {
            val adapter = DetailAdapter(arrayListOf(item))
            binding.detailadapter.adapter = adapter
            binding.detailadapter.layoutManager = LinearLayoutManager(this)
        }

//        binding.detailBack.setOnClickListener {
//        intent = Intent(this, MainActivity::class.java).apply {
//
//        }
//            setResult(RESULT_OK,intent)
//            finish()
//        }


    }
}