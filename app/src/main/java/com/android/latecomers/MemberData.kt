package com.android.latecomers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemberData(val type: Int ,val profile:Int, val name:String, val tel:String,var
isFavorite:
Boolean =
    false): Parcelable{
        companion object{
            val viewType_nomal = 0
            val viewType_recommend = 1
        }
    }