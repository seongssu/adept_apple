package com.android.newsreaderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.newsreaderapp.databinding.TitlefragmentadapterBinding

class TitleFragmentAdapter(private val newList:MutableList<NewsItem>): RecyclerView
.Adapter<RecyclerView.ViewHolder>() {
    interface Click{
        fun onClick(view : View, position: Int)
    }
    var newsClick: TitleFragmentAdapter.Click? = null

    inner class Holder(val binding: TitlefragmentadapterBinding) : RecyclerView.ViewHolder
        (binding.root){
        val profile = binding.titleProfile
        val title = binding.titleTitle
        val time = binding.titleTime
    }

    override fun getItemCount(): Int {
       return newList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = TitlefragmentadapterBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as Holder
        holder.apply {
            profile.setImageResource(newList[position].profile)
            title.text = newList[position].title
            time.text = newList[position].time
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}