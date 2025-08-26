package com.luckyfriday.netflixclone.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luckyfriday.netflixclone.domain.entities.VideoResult
import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetails
import com.luckyfriday.netflixclone.domain.entities.movies.MovieRecommendationResult
import com.luckyfriday.netflixclone.domain.usecases.GetMovieDetailUseCase
import com.luckyfriday.netflixclone.domain.usecases.GetMovieRecommendationUseCase
import com.luckyfriday.netflixclone.domain.usecases.GetVideosUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getMovieRecommendationUseCase: GetMovieRecommendationUseCase,
    private val getVideosUseCase: GetVideosUseCase
) : ViewModel() {

    private val _movie = MutableLiveData<MovieDetails>()
    val movie: LiveData<MovieDetails> = _movie

    private val _recommendations = MutableLiveData<List<MovieRecommendationResult>>()
    val recommendations: LiveData<List<MovieRecommendationResult>> = _recommendations

    private val _videos = MutableLiveData<VideoResult>()
    val videos: LiveData<VideoResult> = _videos

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            try {
                val movie = getMovieDetailUseCase.invoke(movieId)
                _movie.postValue(movie)
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }

    fun getMovieRecommendations(movieId: Int) {
        viewModelScope.launch {
            try {
                val movieRecommendation = getMovieRecommendationUseCase.invoke(movieId)
                _recommendations.postValue(movieRecommendation.results)
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }

    fun getVideos(contentType: String, movieId: Int) {
        viewModelScope.launch {
            try {
                val videos = getVideosUseCase.invoke(contentType, movieId)
                val youtubeVideo = videos.results.find { it.site.equals("youtube", true) }
                _videos.postValue(youtubeVideo!!)
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }

}