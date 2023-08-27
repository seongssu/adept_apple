package com.android.latecomers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.latecomers.databinding.ActivityMainAdapterBinding
import com.android.latecomers.databinding.RecommendedFriendBinding

class MainAdapter(private val izone: MutableList<MemberData>) : RecyclerView
.Adapter<RecyclerView.ViewHolder>() {
    interface mainMemberClick {
        fun onTelClick(view: View, position: Int)
        fun onFavoritesClick(view: View, position: Int)
    }

    var memberClick: MainAdapter.mainMemberClick? = null

    inner class Holder(val binding: ActivityMainAdapterBinding) : RecyclerView.ViewHolder(
        binding
            .root
    ) {
        val profile = binding.mainProfile
        val name = binding.mainName
        val tel = binding.mainTel
        val favorites = binding.mainFavorites
    }

    inner class RecommendedHolder(val binding: RecommendedFriendBinding) : RecyclerView
    .ViewHolder
        (binding.root) {
        val profile_recommended = binding.recommendedProfile
        val name_recommended = binding.recommendedName
        val tel_recommended = binding.recommendedTel
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
    ): RecyclerView.ViewHolder {
//        val binding = ActivityMainAdapterBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent, false
//        )
        return when (viewType) {
            MemberData.viewType_nomal -> {
                val binding = ActivityMainAdapterBinding.inflate(LayoutInflater.from(parent
                    .context),parent,false)
                Holder(binding)
            }

            MemberData.viewType_recommend -> {
                val binding = RecommendedFriendBinding.inflate(LayoutInflater.from(parent
                    .context),parent,false)
                RecommendedHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            MemberData.viewType_nomal ->{
                val normalHolder = holder as Holder
                normalHolder.apply {
                    tel.setOnClickListener {
                        memberClick?.onTelClick(it, position)
                    }
                    favorites.setOnClickListener {
                        memberClick?.onFavoritesClick(it, position)
                    }

                    profile.setImageResource(izone[position].profile)
                    name.text = izone[position].name
                    tel.text = izone[position].tel
                }
            }
            MemberData.viewType_recommend -> {
                val recommendedHolder = holder as RecommendedHolder
                recommendedHolder.apply {
                    profile_recommended.setImageResource(izone[position].profile)
                    name_recommended.text = izone[position].name
                    tel_recommended.text = izone[position].tel
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return izone[position].type
    }
}