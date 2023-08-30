package com.android.latecomers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.latecomers.databinding.ActivityMainAdapterBinding
import com.android.latecomers.databinding.RecommendedFriendBinding
import com.android.latecomers.databinding.TitleNomalBinding

class MainAdapter(private val izone: MutableList<MemberData>) : RecyclerView
.Adapter<RecyclerView.ViewHolder>() {
    interface mainMemberClick {
        fun onProfileClick(view: View, position: Int)
        fun onTelClick(view: View, position: Int)
        fun onFavoritesClick(view: View, position: Int)
    }

    var memberClick: MainAdapter.mainMemberClick? = null

    inner class Holder(val binding: ActivityMainAdapterBinding) : RecyclerView.ViewHolder(
        binding.root) {
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
    }


    inner class titleNomalHolder(val binding: TitleNomalBinding) : RecyclerView.ViewHolder
        (binding.root){
            val title_nomal = binding.titleNomal
        }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getItemCount(): Int {
        return izone.size
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            MemberData.viewType_title_nomal ->{
                val binding = TitleNomalBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false)
                titleNomalHolder(binding)
            }
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
            else -> throw IllegalArgumentException("잘못된 viewType 입니다.")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            MemberData.viewType_title_nomal -> {
                val titleNomalHolder = holder as titleNomalHolder
                titleNomalHolder.apply {
                    title_nomal.text = izone[position].name
                }
            }
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

                    if(izone[position].isFavorite ==true){
                        binding.mainFavorites.setImageResource(R.mipmap.paintedstar)
                    } else {
                        binding.mainFavorites.setImageResource(R.mipmap.star)
                    }
                }
            }
            MemberData.viewType_recommend -> {
                val recommendedHolder = holder as RecommendedHolder
                recommendedHolder.apply {
                   profile_recommended.setOnClickListener {
                       memberClick?.onProfileClick(it, position)
                   }
                    profile_recommended.setImageResource(izone[position].profile)
                    name_recommended.text = izone[position].name
                }
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return izone[position].type
    }
}