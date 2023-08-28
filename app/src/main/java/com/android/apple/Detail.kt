package com.android.apple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apple.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat
import java.util.Locale

class Detail : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
        setContentView(binding.root)

        val item = intent.getParcelableExtra<Item>("item")
        Log.d("Detail item", item.toString())
        val itemList = mutableListOf<Item>()
        if (item != null) itemList.add(item)

        binding.apply {
            detailProfile.setImageResource(itemList[0].profile)
            detailName.text = itemList[0].name
            detailSeller.text = itemList[0].seller
            detailAddress.text = itemList[0].adress
            detailContent.text = itemList[0].content
            detailLove.text = itemList[0].love.toString()
            if(itemList[0].isfavorite) {
                detailBtnlove.setImageResource(R.mipmap.redheart)
            }else {detailBtnlove.setImageResource(R.mipmap.heart)}
            val numberFormat = NumberFormat.getNumberInstance(Locale.US)
            val intprice = numberFormat.format(itemList[0].price)
            val money = "$intprice 원"
            detailPrice.text = money
        }

        binding.detailBack.bringToFront()
        binding.detailBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java).apply {
                intent.putExtra("item",item)
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        binding.detailBtnlove.setOnClickListener {
            val items =itemList[0]
            items.isfavorite = !items.isfavorite
            if ( items.isfavorite) {
                binding.detailBtnlove.setImageResource(R.mipmap.redheart)
                items.love++
                Snackbar.make(binding.root, "관심 목록에 추가되었습니다",Snackbar.LENGTH_SHORT).show()
            } else {
                binding.detailBtnlove.setImageResource(R.mipmap.heart)
                items.love--
            }
            binding.detailLove.text = items.love.toString()
            val item = items
            item.love = items.love
            item.isfavorite = items.isfavorite
        }


    }
}