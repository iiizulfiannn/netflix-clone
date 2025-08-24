package com.luckyfriday.netflixclone.presentation.widget.numbered

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.movies.Movie
import com.luckyfriday.netflixclone.domain.utils.ImageUtils.toImageUrl

class MovieListNumberedAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieListNumberedAdapter.MovieListNumberedViewHolder>() {

    class MovieListNumberedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            val posterImageView: ImageView = itemView.findViewById(R.id.iv_poster)
            Glide.with(itemView.context)
                .load(movie.posterPath.toImageUrl())
                .centerCrop()
                .into(posterImageView)
            val tvRank: TextView = itemView.findViewById(R.id.tv_rank)
            tvRank.text = (adapterPosition + 1).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListNumberedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget_movie_list_numbered, parent, false)
        return MovieListNumberedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieListNumberedViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return 9
    }
}