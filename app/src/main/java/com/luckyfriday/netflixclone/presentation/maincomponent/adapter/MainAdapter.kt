package com.luckyfriday.netflixclone.presentation.maincomponent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.LayoutDataItem
import com.luckyfriday.netflixclone.presentation.maincomponent.viewholder.ListNumberedViewHolder
import com.luckyfriday.netflixclone.presentation.maincomponent.viewholder.ListRegularViewHolder
import com.luckyfriday.netflixclone.presentation.maincomponent.viewholder.SingleMainViewHolder
import com.luckyfriday.netflixclone.presentation.maincomponent.viewtype.MovieListType.*

class MainAdapter(private val layoutData: List<LayoutDataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_LIST_REGULAR.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_list_regular, parent, false)
                ListRegularViewHolder(view)
            }

            TYPE_LIST_NUMBERED.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_list_numbered, parent, false)
                ListNumberedViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_single_main, parent, false)
                SingleMainViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (layoutData[position]) {
            is LayoutDataItem.Popular -> (holder as ListNumberedViewHolder).bind("popular")
            is LayoutDataItem.NowPlaying -> (holder as ListRegularViewHolder).bind("now_playing")
            is LayoutDataItem.Upcoming -> (holder as ListRegularViewHolder).bind("upcoming")
            is LayoutDataItem.TopRated -> (holder as ListRegularViewHolder).bind("top_rated")
            else -> (holder as SingleMainViewHolder).bind()
        }
    }

    override fun getItemCount(): Int {
        return layoutData.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (layoutData[position]) {
            is LayoutDataItem.SingleMain -> TYPE_SINGLE_MAIN.ordinal
            is LayoutDataItem.Popular -> TYPE_LIST_NUMBERED.ordinal
            else -> TYPE_LIST_REGULAR.ordinal
        }
    }
}