package com.luckyfriday.netflixclone.domain.entities

sealed class LayoutDataItem {
    object SingleMain : LayoutDataItem()
    object Popular : LayoutDataItem()
    object Upcoming : LayoutDataItem()
    object NowPlaying : LayoutDataItem()
    object TopRated : LayoutDataItem()
}