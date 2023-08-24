package com.android.apple

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val profile: Int,
    val name: String,
    val content: String,
    val seller: String,
    val price: String,
    val adress: String,
    var love: Int,
    var chat: Int
) : Parcelable