package com.luckyfriday.netflixclone.presentation.widget.numbered

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.MyApplication
import com.luckyfriday.netflixclone.R

class MovieListNumberedWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val tvTitle by lazy { findViewById<TextView>(R.id.tv_title) }
    private val rvMoviePoster by lazy { findViewById<RecyclerView>(R.id.rv_movie_poster) }
    private lateinit var viewModel: MovieListNumberedViewModel
    private var category = "popular"
    private val viewModelStore = ViewModelStore()

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_widget_movie_list_regular, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initViewModel()
        viewModel.getMovieList(category)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModelStore.clear()
    }

    private fun initViewModel() {
        val appContainer = (context.applicationContext as? MyApplication)?.appContainer
        appContainer?.let {
            findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
                viewModel = ViewModelProvider(
                    viewModelStore,
                    it.provideViewModelFactory()
                )[MovieListNumberedViewModel::class.java]
                observeLiveData()
            }
        }
    }

    private fun observeLiveData() {
        findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
            viewModel.movieList.observe(lifecycleOwner) { movieList ->
                val movieListNumberedAdapter = MovieListNumberedAdapter(movies = movieList)
                rvMoviePoster.apply {
                    adapter = movieListNumberedAdapter
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
        }
    }

    fun setCategory(category: String) {
        this.category = category
        tvTitle.text
    }
}