package com.luckyfriday.netflixclone.domain.usecases

import com.luckyfriday.netflixclone.domain.repositories.NetflixRepository

class GetMovieListUseCase(private val netflixRepository: NetflixRepository) {
    suspend operator fun invoke(category: String) = netflixRepository.getMovieList(category)
}