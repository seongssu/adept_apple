package com.android.newsreaderapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.newsreaderapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root

        parentFragmentManager.setFragmentResultListener("titlekey",this){key, result ->
            val getItem = result.getParcelableArrayList<NewsItem>("titleitem")
            Log.d("TitleFragment", "detail에서 받는 데이터 ${getItem.toString()}")
            binding.apply {
                if(!getItem.isNullOrEmpty()){

                    detailTitle.text = getItem[0].title
                    detailProfile.setImageResource(getItem[0].profile)
                    detailTime.text = getItem[0].time
                    detailContent.text = getItem[0].content
                    getItem.clear()
                }

            }

        }


        return view
    }

}