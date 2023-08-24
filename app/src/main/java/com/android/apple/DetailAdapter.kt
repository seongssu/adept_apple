package com.android.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apple.databinding.ActivityDetailAdapterBinding

class DetailAdapter(private val apple: MutableList<Item>) :
    RecyclerView.Adapter<DetailAdapter.Holder>
        () {

    inner class Holder(val binding: ActivityDetailAdapterBinding) : RecyclerView.ViewHolder
        (binding.root) {
        val profile = binding.detailProfile
        val seller = binding.detailSeller
        val temperature = binding.detailTemperature
        val address = binding.detailAddress
        val name = binding.detailName
        val content = binding.detailContent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAdapter.Holder {
        val binding = ActivityDetailAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: DetailAdapter.Holder, position: Int) {
        holder.profile.setImageResource(apple[position].profile)
        holder.seller.text = apple[position].seller
        holder.address.text = apple[position].adress
        holder.name.text = apple[position].name
        holder.content.text = apple[position].content
    }

    override fun getItemCount(): Int {
        return apple.size
    }


}
