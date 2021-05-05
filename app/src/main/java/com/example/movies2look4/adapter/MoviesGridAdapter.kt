package com.example.movies2look4.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies2look4.R
import com.example.movies2look4.models.Movie
import com.example.movies2look4.network.IMG_BASE_URL
import com.example.movies2look4.ui.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_movie_detail.view.*

class MoviesGridAdapter(var moviesList: List<Movie>) :
    RecyclerView.Adapter<MoviesGridAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

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
        val imagePath = moviesList[position].posterPath
        val imgUrl = "${IMG_BASE_URL}${imagePath}"
        Glide.with(holder.itemView.context)
            .load(imgUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(holder.itemView.movie_poster)

        holder.itemView.movie_title.text = moviesList[position].title

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, MovieDetailActivity::class.java)
            intent.apply {
                putExtra("coverUrl", "${IMG_BASE_URL}${moviesList[position].backdropPath}")
                putExtra("posterUrl", imgUrl)
                putExtra("englishTitle", moviesList[position].title)
                putExtra("originalTitle", moviesList[position].originalTitle)
                putExtra("releaseDate", moviesList[position].releaseDate)
                putExtra("rating", moviesList[position].voteAverage.toString())
                putExtra("voteCount", "(${moviesList[position].voteCount.toString()} votes)")
                putExtra("overview", moviesList[position].overview)
            }
            it.context.startActivity(intent)
        }
    }

}