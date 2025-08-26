package com.luckyfriday.netflixclone.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.MyApplication
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.presentation.hot.HotViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private val movieId by lazy { arguments?.getInt("movieId") ?: 0 }

    private lateinit var youtubePlayerView: YouTubePlayerView
    private val movieTitle by lazy { requireView().findViewById<TextView>(R.id.tv_title) }
    private val movieReleaseDate by lazy { requireView().findViewById<TextView>(R.id.tv_release_date) }
    private val movieDescription by lazy { requireView().findViewById<TextView>(R.id.tv_description) }
    private val rvRecommendation by lazy { requireView().findViewById<RecyclerView>(R.id.rv_recommended_movie) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (requireActivity().application as? MyApplication)?.appContainer
        appContainer?.let {
            viewModel =
                ViewModelProvider(this, it.provideViewModelFactory())[DetailViewModel::class.java]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupYoutubeVideoPlayer()
        observeLiveData()
        viewModel.getMovieDetail(movieId)
    }

    private fun setupYoutubeVideoPlayer() {
        youtubePlayerView = requireView().findViewById(R.id.video_player)
        lifecycle.addObserver(youtubePlayerView)
    }

    private fun observeLiveData() {
        viewModel.movie.observe(viewLifecycleOwner) { movie ->
            movieTitle.text = movie.title
            movieReleaseDate.text = movie.releaseDate
            movieDescription.text = movie.overview
            viewModel.getMovieRecommendations(movieId)
            viewModel.getVideos("movie", movieId)
        }

        viewModel.recommendations.observe(viewLifecycleOwner) { recommendations ->
            // populate recyclerView
            val movieRecommendationAdapter = MovieRecommendationAdapter(recommendations)
            rvRecommendation.apply {
                adapter = movieRecommendationAdapter
                layoutManager = GridLayoutManager(context, 3)
            }
        }

        viewModel.videos.observe(viewLifecycleOwner) { videos ->
            youtubePlayerView.getYouTubePlayerWhenReady(object : YouTubePlayerCallback {
                override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(videos.key, 0f)
                }
            })
        }
    }
}