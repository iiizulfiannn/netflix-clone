package com.luckyfriday.netflixclone.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.LayoutDataItem
import com.luckyfriday.netflixclone.presentation.maincomponent.adapter.MainAdapter
import com.luckyfriday.netflixclone.presentation.widget.MovieListListener

class HomeFragment : Fragment(), MovieListListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomeData()
    }

    private fun setupHomeData() {
        val homeData = listOf(
            LayoutDataItem.SingleMain,
            LayoutDataItem.NowPlaying,
            LayoutDataItem.Upcoming,
            LayoutDataItem.Popular,
            LayoutDataItem.TopRated
        )
        val rvHome = view?.findViewById<RecyclerView>(R.id.rv_home)
        val homeAdapter = MainAdapter(homeData, this)
        rvHome?.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onMovieClicked(movieId: Int) {
        TODO("Not yet implemented")
    }
}