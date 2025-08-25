package com.luckyfriday.netflixclone.presentation.maincomponent.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.presentation.widget.MovieListListener
import com.luckyfriday.netflixclone.presentation.widget.numbered.MovieListNumberedWidget

class ListNumberedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(category: String, listener: MovieListListener) {
        val numberedListWidget = itemView.findViewById<MovieListNumberedWidget>(R.id.widget_list_numbered)
        numberedListWidget.setCategory(category)
        numberedListWidget.setListener(listener)
    }
}