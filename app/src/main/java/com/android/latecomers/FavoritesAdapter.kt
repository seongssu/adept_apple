package com.android.latecomers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.latecomers.databinding.ActivityFavoritesAdapterBinding

class FavoritesAdapter (private val izones: MutableList<MemberData>) : RecyclerView
.Adapter<FavoritesAdapter.Holder>() {

    interface favoritesMemberClick {
        fun onTelClick(view: View, position: Int)
        fun onFavoritesClick(view: View, position:Int)
    }

    var memberClick: favoritesMemberClick? = null

    inner class Holder(val binding: ActivityFavoritesAdapterBinding) : RecyclerView.ViewHolder(
        binding
            .root
    ) {
        val profile = binding.favoritesProfile
        val name = binding.favoritesName
        val tel = binding.favoritesTel
        val favorites = binding.favoritesFavorites
    }

    override fun getItemCount(): Int {
        return izones.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        val binding = ActivityFavoritesAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("Fadapter","Fadapter")
        holder.apply {

            tel.setOnClickListener{
                memberClick?.onTelClick(it,position)
            }
            favorites.setOnClickListener {
                memberClick?.onFavoritesClick(it,position)
            }
            Log.d("FavoritesFragment","FavoritesAdapter에서 받은 데이터 ${izones[position]}")
            profile.setImageResource(izones[position].profile)
            name.text = izones[position].name
            tel.text = izones[position].tel

        }

    }
}