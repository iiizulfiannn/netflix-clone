package com.luckyfriday.netflixclone.domain.entities

data class VideosResponse(
    val id: Int,
    val results: List<VideoResult>
)

data class VideoResult(
    val id: String,
    val iso6391: String,
    val iso31661: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val publishedAt: String,
    val site: String,
    val size: Int,
    val type: String
)
