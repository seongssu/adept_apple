package com.android.latecomers

import android.app.Activity
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.latecomers.databinding.FragmentFavoritesBinding
import com.google.android.material.snackbar.Snackbar


class FavoritesFragment : Fragment() {
    private val favoreitesList = arrayListOf<MemberData>()
    private val binding by lazy { FragmentFavoritesBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = binding.root
        Log.d("LifecycleMainActivity", "FFragmaentonCreate")

        parentFragmentManager.setFragmentResultListener("requestKey", this) { key, result ->
            val getFavoritesList = result.getParcelableArrayList<MemberData>("mainFavorites")
            if (getFavoritesList != null) {
                Log.d("FavoritesFragment", "MainFragment에서 넘겨준 데이터를 FavoritesFragment에서 받는 " +
                        "데이터${getFavoritesList}")
                favoritesfragmentData(getFavoritesList)
            }
        }


//        val binding =  FragmentFavoritesBinding.inflate(inflater, container,false)
//        val view = binding.root
//
//        val divider = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
//        binding.favoritesRecyclerview.addItemDecoration(divider)

        return view
    }

    fun favoritesfragmentData(getFavoritesList: ArrayList<MemberData>) {
        val adapter = FavoritesAdapter(getFavoritesList)
        binding.favoritesRecyclerview.adapter = adapter
        binding.favoritesRecyclerview.layoutManager = LinearLayoutManager(requireContext())


        adapter.memberClick = object : FavoritesAdapter.favoritesMemberClick {
            override fun onTelClick(view: View, position: Int) {
                val item = getFavoritesList[position]

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
                Log.d("FavoritesFragment", "onFavoritesClick 호출됨")
                if (position in 0 until getFavoritesList.size) {
                    val item = getFavoritesList[position]
                    item.isFavorite = !item.isFavorite
//                item.isFavorite = false
//                adapter.notifyItemChanged(position)
                    if (item.isFavorite) {
//                    (view as ImageView).setImageResource(R.mipmap.paintedstar)
//                    favoritesList.add(item)
                    }
                    favoreitesList.clear()
                    favoreitesList.add(getFavoritesList[position])
                    getFavoritesList.removeAt(position)
                    adapter.notifyDataSetChanged()
                    adapter.notifyItemRemoved(position)

                    val bundle1 = Bundle()
                    bundle1.putParcelableArrayList("FavoritesFavorites", favoreitesList)
                    Log.d(
                        "FavoritesFragment",
                        "FavoriteFragment에서 MainFragment로 넘겨주는 데이터 : ${favoreitesList}"
                    )
                    setFragmentResult("FavoritesrequestKey", bundle1)

                }
            }
        }
    }
}


