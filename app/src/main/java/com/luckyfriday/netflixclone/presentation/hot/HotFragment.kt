package com.luckyfriday.netflixclone.presentation.hot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.MyApplication
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.movies.Movie
import com.luckyfriday.netflixclone.presentation.widget.MovieListListener
import kotlin.getValue

class HotFragment : Fragment(), MovieListListener {

    private val navController by lazy { findNavController() }
    private lateinit var rvMovieList: RecyclerView
    private lateinit var viewModel: HotViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (requireActivity().application as? MyApplication)?.appContainer
        appContainer?.let {
            viewModel =
                ViewModelProvider(this, it.provideViewModelFactory())[HotViewModel::class.java]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.getMovieList("now_playing")
    }

    private fun observeData() {
        viewModel.movieList.observe(viewLifecycleOwner) { movies ->
            initList(movies)
        }
    }

    private fun initList(movies: List<Movie>) {
        view?.let {
            rvMovieList = it.findViewById(R.id.rv_hot)
            rvMovieList.adapter = HotListAdapter(movies, this)
            rvMovieList.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onMovieClicked(movieId: Int) {
        val bundle = Bundle()
        bundle.putInt("movieId", movieId)
        navController.navigate(R.id.action_hotFragment_to_detailFragment, bundle)
    }
}