package com.example.kymdb.DetailMovies

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kymdb.Movies
import com.example.kymdb.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_MOVIE="key_movie"

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailPoster: ImageView = findViewById(R.id.iv_poster)
        val detailTitle: TextView = findViewById(R.id.tv_title)
        val detailYear: TextView = findViewById(R.id.tv_releasedate)
        val detailGenre: TextView = findViewById(R.id.tv_genre)
        val detailDirector: TextView = findViewById(R.id.tv_director)
        val detailProducer: TextView = findViewById(R.id.tv_producer)
        val detailWriter: TextView = findViewById(R.id.tv_writer)
        val detailActor: TextView = findViewById(R.id.tv_actor)
        val detailDescription: TextView = findViewById(R.id.tv_description)
        val shareButton: Button = findViewById(R.id.action_share)

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
            detailDirector.text = datamovie.director
            detailProducer.text = datamovie.producer
            detailWriter.text = datamovie.writer
            detailActor.text = datamovie.actor
            detailDescription.text = datamovie.description
        } else {
            print("Error Data Movies")
        }
        shareButton.setOnClickListener {
            val goShare = Intent()
            goShare.action = Intent.ACTION_SEND
            if (datamovie != null) {
                goShare.putExtra(
                    Intent.EXTRA_TEXT,
                    "Hey I want to recommend a movie ${datamovie.title} "
                )
            }
            goShare.type = "text/plain"
            startActivity(Intent.createChooser(goShare, "Share To:"))
        }
    }
}