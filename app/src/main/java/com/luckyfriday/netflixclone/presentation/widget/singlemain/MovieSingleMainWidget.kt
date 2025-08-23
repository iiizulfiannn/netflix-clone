package com.luckyfriday.netflixclone.presentation.widget.singlemain

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.bumptech.glide.Glide
import com.luckyfriday.netflixclone.MyApplication
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.utils.ImageUtils.toImageUrl

class MovieSingleMainWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var viewModel: MovieSingleMainViewModel
    private val viewModelStore = ViewModelStore()
    private val ivMoviePoster by lazy { findViewById<ImageView>(R.id.iv_movie_poster) }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_widget_movie_single_main, this, false)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initViewModel()
        viewModel.getMovieDetail()
        ivMoviePoster.setOnClickListener {

        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModelStore.clear()
    }

    private fun initViewModel() {
        val appContainer = (context?.applicationContext as? MyApplication)?.appContainer
        appContainer?.let {
            findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
                viewModel = ViewModelProvider(
                    viewModelStore,
                    it.provideViewModelFactory()
                )[MovieSingleMainViewModel::class.java]
                observeLiveData()
            }
        }
    }

    private fun observeLiveData() {
        findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
            viewModel.movie.observe(lifecycleOwner) { movie ->
                Glide.with(context)
                    .load(movie.posterPath.toImageUrl())
                    .centerCrop()
                    .into(ivMoviePoster)
            }
        }
    }

}