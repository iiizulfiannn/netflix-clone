package com.luckyfriday.netflixclone.domain.entities

data class CreatedBy(
    val id: Int,
    val creditId: String,
    val name: String,
    val gender: Int,
    val profilePath: String?
)
