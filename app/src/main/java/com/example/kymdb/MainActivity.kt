package com.example.kymdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movies>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    private fun getListMovies(): ArrayList<Movies> {
        val dataTitle = resources.getStringArray(R.array.data_movie)
        val dataYear = resources.getIntArray(R.array.data_release)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPoster = resources.getStringArray(R.array.data_poster)
        val listMovies = ArrayList<Movies>()

        for (i in dataTitle.indices) {
            val movies = Movies(dataTitle[i], dataYear[i], dataGenre[i], dataDescription[i], dataPoster[i])
            listMovies.add(movies)
        }

        return listMovies
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter
    }
}