package com.android.latecomers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.latecomers.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment() {
    private val favoritesList = mutableListOf<MemberData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        val modelList = mutableListOf<MemberData>()
        modelList.add(MemberData(R.drawable.character1, "권은비", "010-1111-1111"))
        modelList.add(MemberData(R.drawable.character2, "강혜원", "010-2222-2222"))
        modelList.add(MemberData(R.drawable.character3, "최예나", "010-3333-3333"))
        modelList.add(MemberData(R.drawable.character4, "이채연", "010-4444-4444"))
        modelList.add(MemberData(R.drawable.character5, "김채원", "010-5555-5555"))
        modelList.add(MemberData(R.drawable.character6, "김민주", "010-6666-6666"))
        modelList.add(MemberData(R.drawable.character7, "조유리", "010-7777-7777"))
        modelList.add(MemberData(R.drawable.character8, "안유진", "010-8888-8888"))
        modelList.add(MemberData(R.drawable.character9, "장원영", "010-9999-9999"))
        modelList.add(MemberData(R.drawable.character10, "사쿠라", "010-1234-5678"))

        val adapter = MainAdapter(modelList)
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.layoutManager =
            LinearLayoutManager(requireContext())//this->requireContext()

        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.mainRecyclerview.addItemDecoration(divider)

        parentFragmentManager.setFragmentResultListener(
            "FavoritesrequestKey",
            this@MainFragment
        ) { key, result ->
            val getFavoritesList = result.getParcelableArrayList<MemberData>("FavoritesFavorites")
            Log.d("FavoritesFragment", "MainFragment에서 다시 받는 데이터1: $getFavoritesList")
            if (getFavoritesList != null) {
                modelList.forEach { item ->
                    item.isFavorite = false
                }
                val updatedFavoritesList = mutableListOf<MemberData>()
                updatedFavoritesList.addAll(modelList)
                updatedFavoritesList.addAll(getFavoritesList)
                Log.d("FavoritesFragment", "MainFragment에서 다시 받는 모든 데이터: $updatedFavoritesList")
                adapter.notifyDataSetChanged()
            } else {
                Log.d("FavoritesFragment", "MainFragment에서 다시 받는 데이터3: $getFavoritesList")
            }
        }




        val favoritesList = arrayListOf<MemberData>()
        adapter.memberClick = object : MainAdapter.mainMemberClick {
            override fun onTelClick(view: View, position: Int) {
                val item = modelList[position]

                val phoneNumber = item.tel
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$phoneNumber")
                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Snackbar.make(view, "전화 권한이 없습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }


            override fun onFavoritesClick(view: View, position: Int) {
                val item = modelList[position]
                item.isFavorite = !item.isFavorite
                if (item.isFavorite) {
                    (view as ImageView).setImageResource(R.mipmap.paintedstar)
                    favoritesList.add(item)
                } else {
                    (view as ImageView).setImageResource(R.mipmap.star)
                    favoritesList.remove(item)
                }
                val bundle = Bundle()
                bundle.putParcelableArrayList("mainFavorites", favoritesList)
                Log.d("FavoritesFragment", "MainFragment에서 넘겨주는 데이터 : ${bundle}")
                setFragmentResult("requestKey", bundle)
            }
        }
        return view
    }

}