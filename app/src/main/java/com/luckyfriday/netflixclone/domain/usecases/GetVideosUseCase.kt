package com.luckyfriday.netflixclone.domain.usecases

import com.luckyfriday.netflixclone.domain.repositories.NetflixRepository

class GetVideosUseCase(private val netflixRepository: NetflixRepository) {
    suspend operator fun invoke(contentType: String, contentId: Int) =
        netflixRepository.getVideos(contentType, contentId)
}