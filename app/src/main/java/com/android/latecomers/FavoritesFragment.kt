package com.android.latecomers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.latecomers.databinding.FragmentFavoritesBinding
import com.android.latecomers.databinding.FragmentMainBinding

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoritesBinding.inflate(inflater, container,false)
        val view = binding.root
        return view
    }
}