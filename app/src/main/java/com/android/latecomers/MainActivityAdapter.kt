package com.android.latecomers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.latecomers.databinding.ActivityMainAdapterBinding

class MainActivityAdapter(private val izone: MutableList<MemberData>) : RecyclerView
.Adapter<MainActivityAdapter.Holder>() {

    interface MemberClick {
        fun onClick(view: View, position: Int)
    }

    var memberClick: MemberClick? = null

    inner class Holder(val binding: ActivityMainAdapterBinding) : RecyclerView.ViewHolder(
        binding
            .root
    ) {
        val profile = binding.mainProfile
        val name = binding.mainName
        val tel = binding.mainTel
    }

    override fun getItemCount(): Int {
        return izone.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        val binding = ActivityMainAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.apply {
            itemView.setOnClickListener {
                memberClick?.onClick(it, position)
            }
           profile.setImageResource(izone[position].profile)
            name.text = izone[position].name
            tel.text = izone[position].tel
        }

    }
}