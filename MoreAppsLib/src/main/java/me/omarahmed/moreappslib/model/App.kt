package me.omarahmed.moreappslib.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class App(
    val id: String,
    val name: String,
    val imageUrl: String
) : Parcelable