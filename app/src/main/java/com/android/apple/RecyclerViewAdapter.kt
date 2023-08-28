package com.android.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apple.databinding.ActivityRecyclerViewAdapterBinding
import java.text.NumberFormat
import java.util.Locale

class RecyclerViewAdapter(private val apple: MutableList<Item>) : RecyclerView
.Adapter<RecyclerViewAdapter
.Holder>() {

    interface ItemClick {
        fun onImageClick(view: View, position: Int)
        fun onImageLongClick(view:View, position:Int)
        fun onLoveClick(view: View,position: Int)
    }

    var itemClick: ItemClick? = null

    inner class Holder(val binding: ActivityRecyclerViewAdapterBinding) : RecyclerView.ViewHolder
        (binding.root) {
        val profile = binding.profile
        val name = binding.name
        val address = binding.address
        val price = binding.price
        var chat = binding.chat
        var love = binding.love
        var btn_love = binding.btnLove
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ActivityRecyclerViewAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item =  apple[position]
        if (item.isfavorite) {
            holder.btn_love.setImageResource(R.mipmap.redheart)
        } else {
            holder.btn_love.setImageResource(R.mipmap.heart)
        }
        holder.apply {
            profile.setOnClickListener {
                itemClick?.onImageClick(it, position)
            }
            profile.setOnLongClickListener {
                itemClick?.onImageLongClick(it, position)
                true
            }
            btn_love.setOnClickListener {
                itemClick?.onLoveClick(it,position)
            }
            profile.setImageResource(apple[position].profile)
            name.text = apple[position].name
            address.text = apple[position].adress
            chat.text = apple[position].chat.toString()
            love.text = apple[position].love.toString()

            val numberFormat = NumberFormat.getNumberInstance(Locale.US)
            val intprice = numberFormat.format(apple[position].price)
            val money = "$intprice 원"
            holder.price.text = money
        }
    }

    override fun getItemCount(): Int {
        return apple.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}