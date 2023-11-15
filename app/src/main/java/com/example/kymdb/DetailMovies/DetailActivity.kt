package com.example.kymdb.DetailMovies

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kymdb.Movies
import com.example.kymdb.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_MOVIE="key_movie"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailPoster: ImageView = findViewById(R.id.iv_poster)
        val detailTitle: TextView = findViewById(R.id.tv_title)
        val detailYear: TextView = findViewById(R.id.tv_releasedate)
        val detailGenre: TextView = findViewById(R.id.tv_genre)
        val detailDescription: TextView = findViewById(R.id.tv_description)

        val datamovie = if (Build.VERSION.SDK_INT > 33) {
            intent.getParcelableExtra<Movies>(KEY_MOVIE, Movies::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Movies>(KEY_MOVIE)
        }

        if (datamovie != null) {
            Glide.with(this)
                .load(datamovie.poster)
                .into(detailPoster)
            detailTitle.text = datamovie.title
            detailYear.text = datamovie.year.toString()
            detailGenre.text = datamovie.genre
            detailDescription.text = datamovie.description
        } else {
            print("Error Data Movies")
        }
    }
}