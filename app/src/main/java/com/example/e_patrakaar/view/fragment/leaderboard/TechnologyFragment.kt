package com.example.e_patrakaar.view.fragment.leaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.databinding.FragmentTechnologyBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.adapter.ChannelAdapter
import com.example.e_patrakaar.view.adapter.RecommendedAdapter
import com.example.e_patrakaar.view.adapter.TrendingNewsAdapter


class TechnologyFragment : Fragment() {

    private lateinit var binding: FragmentTechnologyBinding
    private lateinit var list: List<Collection>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTechnologyBinding.inflate(inflater, container, false)
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
        binding.rvTechnologyTop.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvTechnologyTop.adapter = TrendingNewsAdapter(this@TechnologyFragment, list)

        binding.rvLatestTechno.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestTechno.adapter = TrendingNewsAdapter(this@TechnologyFragment, list)

        binding.rvLatestTechno2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestTechno2.adapter = TrendingNewsAdapter(this@TechnologyFragment, list)

        binding.rvTopTenTechnology.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvTopTenTechnology.adapter = TrendingNewsAdapter(this@TechnologyFragment, list)

        binding.rvRecentTechnologyUpdates1.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentTechnologyUpdates1.adapter = ChannelAdapter(this@TechnologyFragment, list)

        binding.rvRecentTechnologyUpdates2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentTechnologyUpdates2.adapter = RecommendedAdapter(this@TechnologyFragment, list)

    }

}