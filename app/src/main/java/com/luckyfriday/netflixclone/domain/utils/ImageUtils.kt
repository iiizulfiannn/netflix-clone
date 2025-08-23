package com.luckyfriday.netflixclone.domain.utils

object ImageUtils {
    fun String.toImageUrl(size: String = "w500"): String {
        val baseUrl = "https://image.tmdb.org/t/p/$size"
        return baseUrl + this
    }
}