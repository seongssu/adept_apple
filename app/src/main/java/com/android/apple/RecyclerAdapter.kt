package com.android.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apple.databinding.ActivityRecyclerAdapterBinding

class RecyclerViewAdapter(val apple: MutableList<Item>) : RecyclerView.Adapter<RecyclerViewAdapter
.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    inner class Holder(val binding: ActivityRecyclerAdapterBinding) : RecyclerView.ViewHolder
        (binding.root) {
        val profile = binding.profile
        val name = binding.name
        val address = binding.address
        val price = binding.price
        val chat = binding.chat
        val love = binding.love
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ActivityRecyclerAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it, position)
        }
        holder.profile.setImageResource(apple[position].profile)
        holder.name.text = apple[position].name
        holder.address.text = apple[position].adress
        holder.price.text = apple[position].price
    }

    override fun getItemCount(): Int {
        return apple.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}
