package com.luckyfriday.netflixclone.data.mapper

import com.luckyfriday.netflixclone.data.dto.GenreDTO
import com.luckyfriday.netflixclone.data.dto.ProductionCompanyDTO
import com.luckyfriday.netflixclone.data.dto.ProductionCountryDTO
import com.luckyfriday.netflixclone.data.dto.SpokenLanguageDTO
import com.luckyfriday.netflixclone.data.dto.VideoResultDTO
import com.luckyfriday.netflixclone.data.dto.VideosResponseDTO
import com.luckyfriday.netflixclone.data.dto.movies.MovieDTO
import com.luckyfriday.netflixclone.data.dto.movies.MovieDetailResponseDTO
import com.luckyfriday.netflixclone.data.dto.movies.MovieRecommendationResponseDTO
import com.luckyfriday.netflixclone.data.dto.movies.MovieRecommendationResultDTO
import com.luckyfriday.netflixclone.data.dto.movies.MovieResponseDTO
import com.luckyfriday.netflixclone.domain.entities.Genre
import com.luckyfriday.netflixclone.domain.entities.ProductionCompany
import com.luckyfriday.netflixclone.domain.entities.ProductionCountry
import com.luckyfriday.netflixclone.domain.entities.SpokenLanguage
import com.luckyfriday.netflixclone.domain.entities.VideoResult
import com.luckyfriday.netflixclone.domain.entities.VideosResponse
import com.luckyfriday.netflixclone.domain.entities.movies.Movie
import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetail
import com.luckyfriday.netflixclone.domain.entities.movies.MovieRecommendationResult
import com.luckyfriday.netflixclone.domain.entities.movies.MovieRecommendations
import com.luckyfriday.netflixclone.domain.entities.movies.MovieResponse

class Mapper {

    fun mapVideoResponse(videosResponseDTO: VideosResponseDTO): VideosResponse {
        return videosResponseDTO.toVideoResponse()
    }

    fun mapMovieResponse(movieResponseDTO: MovieResponseDTO): MovieResponse {
        return movieResponseDTO.toMovieResponse()
    }

    fun mapMovieDetailResponse(movieDetailResponseDTO: MovieDetailResponseDTO): MovieDetail {
        return movieDetailResponseDTO.toMovieDetails()
    }

    fun mapMovieRecommendationResponse(movieRecommendationResponseDTO: MovieRecommendationResponseDTO): MovieRecommendations {
        return movieRecommendationResponseDTO.toMovieRecommendations()
    }

    private fun VideosResponseDTO.toVideoResponse(): VideosResponse {
        return VideosResponse(
            id = id,
            results = results.map { it.toVideoResult() }
        )
    }

    private fun VideoResultDTO.toVideoResult(): VideoResult {
        return VideoResult(
            id = id,
            iso6391 = iso6391,
            iso31661 = iso31661,
            key = key,
            name = name,
            official = official,
            publishedAt = publishedAt,
            site = site,
            size = size,
            type = type
        )
    }

    private fun MovieResponseDTO.toMovieResponse(): MovieResponse {
        return MovieResponse(
            page = page,
            results = results.map { it.toMovie() },
            totalPages = totalPages,
            totalResults = totalResults
        )
    }

    private fun MovieDTO.toMovie(): Movie {
        return Movie(
            adult = adult,
            backdropPath = backdropPath,
            genreIds = genreIds,
            id = id,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }

    private fun MovieDetailResponseDTO.toMovieDetails(): MovieDetail {
        return MovieDetail(
            adult = adult,
            backdropPath = backdropPath,
            belongsToCollection = belongsToCollection,
            budget = budget,
            genres = genres.map { it.toGenre() },
            homepage = homepage,
            id = id,
            imdbId = imdbId,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            productionCompanies = productionCompanies.map { it.toProductionCompany() },
            productionCountries = productionCountries.map { it.toProductionCountry() },
            releaseDate = releaseDate,
            revenue = revenue,
            runtime = runtime,
            spokenLanguages = spokenLanguages.map { it.toSpokenLanguage() },
            status = status,
            tagline = tagline,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount,
            originCountry = originCountry
        )
    }

    private fun GenreDTO.toGenre(): Genre {
        return Genre(
            id = id,
            name = name
        )
    }

    private fun ProductionCompanyDTO.toProductionCompany(): ProductionCompany {
        return ProductionCompany(
            id = id,
            logoPath = logoPath,
            name = name,
            originCountry = originCountry
        )
    }

    private fun ProductionCountryDTO.toProductionCountry(): ProductionCountry {
        return ProductionCountry(
            iso31661 = iso31661,
            name = name
        )
    }

    private fun SpokenLanguageDTO.toSpokenLanguage(): SpokenLanguage {
        return SpokenLanguage(
            englishName = englishName,
            iso6391 = iso6391,
            name = name
        )
    }

    private fun MovieRecommendationResponseDTO.toMovieRecommendations(): MovieRecommendations {
        return MovieRecommendations(
            page = page,
            results = results.map { it.toMovieRecommendationResult() },
            totalPages = totalPages,
            totalResults = totalResults
        )
    }

    private fun MovieRecommendationResultDTO.toMovieRecommendationResult(): MovieRecommendationResult {
        return MovieRecommendationResult(
            adult = adult,
            backdropPath = backdropPath,
            genreIds = genreIds,
            id = id,
            mediaType = mediaType,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }
}