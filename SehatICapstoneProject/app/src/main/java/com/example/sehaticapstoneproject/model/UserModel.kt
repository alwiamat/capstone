package com.example.sehaticapstoneproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel (
    val id: Int,
    val nickname: String,
    val profileUrl: String
) : Parcelable