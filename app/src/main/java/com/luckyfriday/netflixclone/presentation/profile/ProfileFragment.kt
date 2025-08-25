package com.luckyfriday.netflixclone.presentation.profile

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

class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupProfileData()
    }

    private fun setupProfileData() {
        val profileData = listOf(
            LayoutDataItem.Popular,
            LayoutDataItem.NowPlaying,
            LayoutDataItem.Upcoming,
            LayoutDataItem.TopRated
        )
        val rvProfile = view?.findViewById<RecyclerView>(R.id.rv_profile)
        val profileAdapter = MainAdapter(profileData)
        rvProfile?.apply {
            adapter = profileAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}