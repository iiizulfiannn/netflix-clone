package com.luckyfriday.netflixclone.data.repositories

import com.luckyfriday.netflixclone.data.mapper.Mapper
import com.luckyfriday.netflixclone.data.source.api.NetflixApiService
import com.luckyfriday.netflixclone.domain.entities.VideosResponse
import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetail
import com.luckyfriday.netflixclone.domain.entities.movies.MovieRecommendations
import com.luckyfriday.netflixclone.domain.entities.movies.MovieResponse
import com.luckyfriday.netflixclone.domain.repositories.NetflixRepository

class NetflixRepositoryImpl(
    private val netflixApiService: NetflixApiService,
    private val mapper: Mapper
): NetflixRepository {
    override suspend fun getVideos(contentType: String, contentId: Int): VideosResponse {
        val response = netflixApiService.getVideos(contentType, contentId)
        return mapper.mapVideoResponse(response)
    }

    override suspend fun getMovieList(category: String): MovieResponse {
        val response = netflixApiService.getMovieList(category)
        return mapper.mapMovieResponse(response)
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        val response = netflixApiService.getMovieDetail(movieId)
        return mapper.mapMovieDetailResponse(response)
    }

    override suspend fun getMovieRecommendations(movieId: Int): MovieRecommendations {
        val response = netflixApiService.getMovieRecommendations(movieId)
        return mapper.mapMovieRecommendationResponse(response)
    }
}