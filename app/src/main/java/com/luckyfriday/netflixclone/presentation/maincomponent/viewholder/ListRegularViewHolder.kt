package com.luckyfriday.netflixclone.presentation.maincomponent.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.presentation.widget.regular.MovieListRegularWidget

class ListRegularViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(category: String) {
        val regularListWidget = itemView.findViewById<MovieListRegularWidget>(R.id.widget_list_regular)
        regularListWidget.setCategory(category)
    }
}