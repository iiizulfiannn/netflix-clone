package com.luckyfriday.netflixclone.data.dto

import com.google.gson.annotations.SerializedName

data class ProductionCompanyDTO(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("logo_path") val logoPath: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("origin_country") val originCountry: String = ""
)
