package com.luckyfriday.netflixclone.di

import android.content.Context
import com.luckyfriday.netflixclone.AppViewModelFactory
import com.luckyfriday.netflixclone.data.mapper.Mapper
import com.luckyfriday.netflixclone.data.repositories.NetflixRepositoryImpl
import com.luckyfriday.netflixclone.data.source.api.NetflixApiService
import com.luckyfriday.netflixclone.data.source.api.RetrofitClient
import com.luckyfriday.netflixclone.domain.usecases.GetMovieDetailUseCase
import com.luckyfriday.netflixclone.domain.usecases.GetMovieListUseCase
import com.luckyfriday.netflixclone.domain.usecases.GetMovieRecommendationUseCase
import com.luckyfriday.netflixclone.domain.usecases.GetVideosUseCase
import com.luckyfriday.netflixclone.presentation.widget.singlemain.MovieSingleMainViewModel

class AppContainer(context: Context) {

    // ==========================================
    // API Section
    // ==========================================
    private val retrofit = RetrofitClient(context = context).retrofit
    private val netflixApiService by lazy { retrofit.create(NetflixApiService::class.java) }

    // ==========================================
    // Repository Section
    // ==========================================
    private val mapper by lazy { Mapper() }
    private val netflixRepository by lazy { NetflixRepositoryImpl(netflixApiService, mapper) }

    // ==========================================
    // UseCase Section
    // ==========================================
    private val getVideosUseCase by lazy { GetVideosUseCase(netflixRepository) }
    private val getMovieListUseCase by lazy { GetMovieListUseCase(netflixRepository) }
    private val getMovieDetailUseCase by lazy { GetMovieDetailUseCase(netflixRepository) }
    private val getMovieRecommendationUseCase by lazy { GetMovieRecommendationUseCase(netflixRepository) }

    // ==========================================
    // ViewModel Section
    // ==========================================
    fun provideViewModelFactory(): AppViewModelFactory {
        return AppViewModelFactory().apply {
            // register viewModel
            registerCreator(MovieSingleMainViewModel::class.java) { MovieSingleMainViewModel(getMovieDetailUseCase) }
        }
    }
}