package com.example.portofoliomahasiswa

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Portofolio(
    var nama: String,
    var username: String,
    var avatar: Int
):Parcelable
