package com.luckyfriday.netflixclone.domain.usecases

import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetails
import com.luckyfriday.netflixclone.domain.repositories.NetflixRepository

class GetMovieDetailUseCase(private val netflixRepository: NetflixRepository) {
    suspend operator fun invoke(movieId: Int): MovieDetails = netflixRepository.getMovieDetail(movieId)
}