package com.luckyfriday.netflixclone.presentation.widget.singlemain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetails
import com.luckyfriday.netflixclone.domain.usecases.GetMovieDetailUseCase
import kotlinx.coroutines.launch

class MovieSingleMainViewModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {

    private val _movie = MutableLiveData<MovieDetails>()
    val movie: LiveData<MovieDetails> = _movie

    fun getMovieDetail() {
        viewModelScope.launch {
            try {
                val movie = getMovieDetailUseCase.invoke(129)
                _movie.postValue(movie)
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }

}