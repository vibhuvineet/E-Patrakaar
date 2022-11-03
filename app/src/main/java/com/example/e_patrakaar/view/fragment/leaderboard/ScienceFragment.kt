package com.example.e_patrakaar.view.fragment.leaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.databinding.FragmentScienceBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.adapter.ChannelAdapter
import com.example.e_patrakaar.view.adapter.RecommendedAdapter
import com.example.e_patrakaar.view.adapter.TrendingNewsAdapter


class ScienceFragment : Fragment() {

    private lateinit var binding: FragmentScienceBinding
    private lateinit var list: List<Collection>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScienceBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = listOf(
            Collection("one"),
            Collection("two"),
            Collection("three"),
            Collection("four"),
            Collection("five"),
            Collection("six"),
        )
        binding.rvScienceTop.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvScienceTop.adapter = TrendingNewsAdapter(this@ScienceFragment, list)

        binding.rvLatestScience.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestScience.adapter = TrendingNewsAdapter(this@ScienceFragment, list)

        binding.rvLatestScience2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestScience2.adapter = TrendingNewsAdapter(this@ScienceFragment, list)

        binding.rvTopTenScience.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvTopTenScience.adapter = TrendingNewsAdapter(this@ScienceFragment, list)

        binding.rvRecentScienceUpdates1.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentScienceUpdates1.adapter = ChannelAdapter(this@ScienceFragment, list)

        binding.rvRecentScienceUpdates2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentScienceUpdates2.adapter = RecommendedAdapter(this@ScienceFragment, list)

    }

}