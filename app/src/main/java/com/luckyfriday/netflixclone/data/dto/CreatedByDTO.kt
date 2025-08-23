package com.luckyfriday.netflixclone.data.dto

import com.google.gson.annotations.SerializedName

data class CreatedByDTO(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("credit_id") val creditId: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("gender") val gender: Int = 0,
    @SerializedName("profile_path") val profilePath: String = ""
)