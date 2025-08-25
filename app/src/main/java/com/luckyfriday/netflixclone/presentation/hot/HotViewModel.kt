package com.luckyfriday.netflixclone.presentation.hot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luckyfriday.netflixclone.domain.entities.movies.Movie
import com.luckyfriday.netflixclone.domain.usecases.GetMovieListUseCase
import kotlinx.coroutines.launch

class HotViewModel(val getMovieListUseCase: GetMovieListUseCase): ViewModel()  {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    fun getMovieList(category: String) {
        viewModelScope.launch {
            try {
                val movieList = getMovieListUseCase.invoke(category)
                _movieList.value = movieList.results
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }
}