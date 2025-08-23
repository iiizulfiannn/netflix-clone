package com.luckyfriday.netflixclone.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.domain.entities.LayoutDataItem

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setupHomeData() {
        val homeData = listOf(
            LayoutDataItem.SingleMain,
            LayoutDataItem.NowPlaying,
            LayoutDataItem.Upcoming,
            LayoutDataItem.Popular,
            LayoutDataItem.TopRated
        )
    }
}