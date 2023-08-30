package com.android.newsreaderapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsItem (val profile:Int, val title:String, val content:String, val time:String) :
    Parcelable, conect

interface conect{}

data class title(val title:String) : conect