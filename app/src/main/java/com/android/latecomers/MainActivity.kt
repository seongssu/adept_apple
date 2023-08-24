package com.android.latecomers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.latecomers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val modelList = mutableListOf<MemberData>()
        modelList.add(MemberData(R.drawable.character1,"권은비","010-1111-1111"))
        modelList.add(MemberData(R.drawable.character2,"강혜원","010-2222-2222"))
        modelList.add(MemberData(R.drawable.character3,"최예나","010-3333-3333"))
        modelList.add(MemberData(R.drawable.character4,"이채연","010-4444-4444"))
        modelList.add(MemberData(R.drawable.character5,"김채원","010-5555-5555"))
        modelList.add(MemberData(R.drawable.character6,"김민주","010-6666-6666"))
        modelList.add(MemberData(R.drawable.character7,"조유리","010-7777-7777"))
        modelList.add(MemberData(R.drawable.character8,"안유진","010-8888-8888"))
        modelList.add(MemberData(R.drawable.character9,"장원영","010-9999-9999"))
        modelList.add(MemberData(R.drawable.character10,"사쿠라","010-1234-5678"))

        binding.recyclerview.adapter = MainActivityAdapter(modelList)
        val adapter = MainActivityAdapter(modelList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val divider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.recyclerview.addItemDecoration(divider)

        adapter.memberClick = object : MainActivityAdapter.MemberClick{
            override fun onClick(view: View, position:Int){
                val item = modelList[position]
            }
        }
    }
}