package com.example.movies2look4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies2look4.R
import com.example.movies2look4.extensions.toImageUrl
import com.example.movies2look4.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.view.*

class MoviesGridAdapter(
    private val moviesList: List<Movie>,
    private val onMovieClickListener: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesGridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bind(movie, onMovieClickListener)
    }

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            movie: Movie,
            onMovieClickListener: (Movie) -> Unit
        ) {
            Glide.with(itemView.context)
                .load(movie.posterPath?.toImageUrl())
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                )
                .into(itemView.movie_poster)

            itemView.movie_title.text = movie.title

            itemView.setOnClickListener {
                onMovieClickListener(movie)
            }
        }
    }
}