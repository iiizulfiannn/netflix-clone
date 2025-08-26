package com.luckyfriday.netflixclone.domain.repositories

import com.luckyfriday.netflixclone.domain.entities.VideosResponse
import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetails
import com.luckyfriday.netflixclone.domain.entities.movies.MovieRecommendations
import com.luckyfriday.netflixclone.domain.entities.movies.MovieResponse

interface NetflixRepository {
    suspend fun getVideos(contentType: String, contentId: Int): VideosResponse
    suspend fun getMovieList(category: String): MovieResponse
    suspend fun getMovieDetail(movieId: Int): MovieDetails
    suspend fun getMovieRecommendations(movieId: Int): MovieRecommendations
}