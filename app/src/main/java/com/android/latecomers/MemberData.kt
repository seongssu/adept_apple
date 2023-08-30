package com.android.latecomers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemberData(
    var type: Int, val profile: Int, val name: String, val tel: String, var
    select: Boolean, var isFavorite: Boolean = false
) : Parcelable {
    companion object {
        var viewType_nomal = 1
        var viewType_recommend = 2
        var viewType_title_nomal = 0

    }
}