package com.example.kymdb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    var title: String,
    var year: Int,
    var genre: String,
    var director: String,
    var producer: String,
    var writer: String,
    var actor: String,
    var description: String,
    var poster: String
) : Parcelable
