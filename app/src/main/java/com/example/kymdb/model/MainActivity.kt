package com.example.kymdb.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kymdb.Movies
import com.example.kymdb.R
import com.example.kymdb.adapter.ListMovieAdapter
import com.example.kymdb.menu.about

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movies>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_about -> {
                val MoveAbout = Intent(this@MainActivity, about::class.java)
                startActivity(MoveAbout)
            }
         }
        return super.onOptionsItemSelected(item)
    }
}