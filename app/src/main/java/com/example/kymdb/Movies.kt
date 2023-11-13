package com.example.kymdb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    var name: String,
    var year: Int,
    var genre: String,
    var description: String,
    var poster: String
) : Parcelable
