package com.android.latecomers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemberData(val profile:Int, val name:String, val tel:String,var isFavorite: Boolean =
    false): Parcelable