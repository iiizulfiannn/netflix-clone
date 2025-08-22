package com.luckyfriday.netflixclone.data.source.api

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Properties

class RetrofitClient(private val context: Context) {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3"
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor(AuthorizationInterceptor(getApiKey()))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getApiKey(): String {
        return try {
            val inputSteram = context.assets.open("secrets.properties")
            val properties = Properties()
            properties.load(inputSteram)
            properties.getProperty("API_KEY") ?: ""
        } catch (e: Exception) {
            ""
        }
    }

}