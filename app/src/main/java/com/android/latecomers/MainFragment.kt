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
import com.android.latecomers.MemberData.Companion.viewType_nomal
import com.android.latecomers.MemberData.Companion.viewType_recommend
import com.android.latecomers.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment() {
    private val favoritesList = arrayListOf<MemberData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        val modelList = mutableListOf<MemberData>()
        modelList.add(MemberData(0, 0, "추천 친구 목록", ""))
        modelList.add(MemberData(2, R.drawable.character11, "나코", "010-1357-1357"))
        modelList.add(MemberData(2, R.drawable.character12, "히토미", "010-2468-2468"))
        modelList.add(MemberData(0, 0, "친구 목록", ""))
        modelList.add(MemberData(1, R.drawable.character1, "권은비", "010-1111-1111"))
        modelList.add(MemberData(1, R.drawable.character2, "강혜원", "010-2222-2222"))
        modelList.add(MemberData(1, R.drawable.character3, "최예나", "010-3333-3333"))
        modelList.add(MemberData(1, R.drawable.character4, "이채연", "010-4444-4444"))
        modelList.add(MemberData(1, R.drawable.character5, "김채원", "010-5555-5555"))
        modelList.add(MemberData(1, R.drawable.character6, "김민주", "010-6666-6666"))
        modelList.add(MemberData(1, R.drawable.character7, "조유리", "010-7777-7777"))
        modelList.add(MemberData(1, R.drawable.character8, "안유진", "010-8888-8888"))
        modelList.add(MemberData(1, R.drawable.character9, "장원영", "010-9999-9999"))
        modelList.add(MemberData(1, R.drawable.character10, "사쿠라", "010-1234-5678"))

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
            Log.d(
                "FavoritesFragment", "MainFragment에서 Favorites에서 넘겨준 데이터를 다시 받는 데이터: " +
                        "$getFavoritesList"
            )

            if (getFavoritesList != null) {
                getFavoritesList.forEach { item ->
                    Log.d("FavoritesFragment","지금 ${modelList}")
                    val index = modelList.indexOfFirst { it.name == item.name }
                    modelList[index].isFavorite = false

                }
            }
//                    item.isFavorite = false
//                    adapter.notifyDataSetChanged()
            adapter.notifyDataSetChanged()
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
                Log.d("FavoritesFragment","지금item ${item}")
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

            override fun onProfileClick(view: View, position: Int) {
                val item = modelList[position]
                if (item.type == 2) {
                    item.type = 1
                    modelList.remove(item)
                    modelList.add(item)
                    Log.d("FavoritesFragment", "itemtype : ${item}")
                    adapter.notifyDataSetChanged()
                }
            }
        }
        return view
    }

}