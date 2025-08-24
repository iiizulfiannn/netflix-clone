package com.luckyfriday.netflixclone.presentation.maincomponent.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.presentation.widget.singlemain.MovieSingleMainWidget

class SingleMainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind() {
        val singleMainWidget = itemView.findViewById<MovieSingleMainWidget>(R.id.widget_movie_single_main)
    }
}