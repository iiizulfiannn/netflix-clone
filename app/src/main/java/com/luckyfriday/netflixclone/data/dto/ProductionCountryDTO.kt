package com.luckyfriday.netflixclone.data.dto

data class ProductionCountryDTO(
    @SerializedName("iso_3166_1") val iso31661: String = "",
    @SerializedName("name") val name: String = ""
)
