package com.example.kymdb.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kymdb.DetailMovies.DetailActivity
import com.example.kymdb.Movies
import com.example.kymdb.R

class ListMovieAdapter(private val listMovie : ArrayList<Movies>) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvYear: TextView = itemView.findViewById(R.id.tv_releasedate)
        val tvGenre: TextView = itemView.findViewById(R.id.tv_genre)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        val imgPoster: ImageView = itemView.findViewById(R.id.iv_poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movies, parent, false)
        return  ListViewHolder(view)
    }

    override fun getItemCount() : Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val (title, year, genre, director, producer, writer, actor, description, poster) = listMovie[position]
        holder.tvTitle.text = title
        holder.tvYear.text = year.toString()
        holder.tvGenre.text = genre
        holder.tvDescription.text = description
        Glide.with(holder.itemView.context)
            .load(poster)
            .into(holder.imgPoster)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.KEY_MOVIE, listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}


