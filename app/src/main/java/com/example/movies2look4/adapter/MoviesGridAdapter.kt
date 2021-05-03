package com.example.movies2look4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies2look4.R
import com.example.movies2look4.models.Movie
import com.example.movies2look4.models.MovieFewInfo
import com.example.movies2look4.network.MoviesApiResponseDetails

class MoviesGridAdapter(var moviesList: List<MovieFewInfo>) : RecyclerView.Adapter<MoviesGridAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieTitle = view.findViewById<TextView>(R.id.movie_title)
        val moviePoster = view.findViewById<ImageView>(R.id.movie_poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrl = moviesList[position].title.image.url
        Glide.with(holder.itemView.context)
            .load(imgUrl)
            .into(holder.moviePoster)

        holder.movieTitle.text = moviesList[position].title.title

        holder.itemView.setOnClickListener {
            println(moviesList[position].title.title)
        }
    }

}