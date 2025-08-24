package com.luckyfriday.netflixclone.presentation.widget.regular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.movies.Movie
import com.luckyfriday.netflixclone.domain.utils.ImageUtils.toImageUrl

class MovieListRegularAdapter(
    private val movies: List<Movie>,
    private val showPlayButton: Boolean = false,
) : RecyclerView.Adapter<MovieListRegularAdapter.MovieListRegularViewHolder>() {

    class MovieListRegularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie, showPlayButton: Boolean) {
            val posterImageView: ImageView = itemView.findViewById(R.id.iv_movie_poster)
            Glide.with(itemView.context)
                .load(movie.posterPath.toImageUrl())
                .centerCrop()
                .into(posterImageView)
            val ivRank: ImageView = itemView.findViewById(R.id.iv_rank)
            ivRank.visibility = if (movie.voteAverage > 7) View.VISIBLE else View.GONE
            val playButton = itemView.findViewById<ImageView>(R.id.btn_play)
            playButton.visibility = if (showPlayButton) View.VISIBLE else View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListRegularViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget_movie_list_regular, parent, false)
        return MovieListRegularViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieListRegularViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, showPlayButton)
    }

    override fun getItemCount(): Int {
        return 9
    }
}