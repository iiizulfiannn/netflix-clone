package com.luckyfriday.netflixclone.data.dto

import com.google.gson.annotations.SerializedName

data class CreatedByDTO(
    @SerializedName("id") val id: Int = 0,
    @SerializeName("credit_id") val creditId: String = "",
    @SerializeName("name") val name: String = "",
    @SerializeName("gender") val gender: Int = 0,
    @SerializeName("profile_path") val profilePath: String = ""
)