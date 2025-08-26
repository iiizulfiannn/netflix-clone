package com.luckyfriday.netflixclone.presentation.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.movies.MovieRecommendationResult
import com.luckyfriday.netflixclone.domain.utils.ImageUtils.toImageUrl

class MovieRecommendationAdapter(
    private val movies: List<MovieRecommendationResult>
) : RecyclerView.Adapter<MovieRecommendationAdapter.MovieRecommendationViewHolder>() {

    class MovieRecommendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieRecommendationResult) {
            val posterImageView: ImageView = itemView.findViewById(R.id.iv_movie_poster)
            Glide.with(itemView.context)
                .load(movie.posterPath.toImageUrl())
                .centerCrop()
                .into(posterImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecommendationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget_movie_list_regular, parent, false)
        return MovieRecommendationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieRecommendationViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}