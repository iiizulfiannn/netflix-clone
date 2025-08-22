package com.luckyfriday.netflixclone.data.dto

import com.google.gson.annotations.SerializedName

data class VideosResponseDTO(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("results") val results: List<VideoResultDTO> = emptyList()
)

data class VideoResultDTO(
    @SerializedName("iso_639_1") val iso6391: String = "",
    @SerializedName("iso_3166_1") val iso31661: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("key") val key: String = "",
    @SerializedName("site") val site: String = "",
    @SerializedName("size") val size: Int = 0,
    @SerializedName("type") val type: String = "",
    @SerializedName("official") val official: Boolean = false,
    @SerializedName("published_at") val publishedAt: String = "",
    @SerializedName("id") val id: String = ""
)


