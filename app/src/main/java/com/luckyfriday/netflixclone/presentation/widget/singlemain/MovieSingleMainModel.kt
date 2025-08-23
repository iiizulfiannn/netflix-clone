package com.luckyfriday.netflixclone.presentation.widget.singlemain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luckyfriday.netflixclone.domain.entities.movies.MovieDetail
import com.luckyfriday.netflixclone.domain.usecases.GetMovieDetailUseCase
import kotlinx.coroutines.launch

class MovieSingleMainModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) : ViewModel() {

    private val _movie = MutableLiveData<MovieDetail>()
    val movie: LiveData<MovieDetail> = _movie

    fun getMovieDetail() {
        viewModelScope.launch {
            try {
                val movie = getMovieDetailUseCase.invoke(129)
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }

}