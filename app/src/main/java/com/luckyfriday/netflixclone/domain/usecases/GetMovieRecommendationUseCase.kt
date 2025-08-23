package com.luckyfriday.netflixclone.domain.usecases

import com.luckyfriday.netflixclone.domain.repositories.NetflixRepository

class GetMovieRecommendationUseCase(private val netflixRepository: NetflixRepository) {
    suspend operator fun invoke(movieId: Int) = netflixRepository.getMovieRecommendations(movieId)
}