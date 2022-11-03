package com.example.e_patrakaar.view.fragment.leaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.databinding.FragmentHealthBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.adapter.ChannelAdapter
import com.example.e_patrakaar.view.adapter.RecommendedAdapter
import com.example.e_patrakaar.view.adapter.TrendingNewsAdapter


class HealthFragment : Fragment() {

    private lateinit var binding: FragmentHealthBinding
    private lateinit var list: List<Collection>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHealthBinding.inflate(inflater, container, false)
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
        binding.rvHealthTop.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvHealthTop.adapter = TrendingNewsAdapter(this@HealthFragment, list)

        binding.rvLatestTechnology.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestTechnology.adapter = TrendingNewsAdapter(this@HealthFragment, list)

        binding.rvLatestTechnology2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestTechnology2.adapter = TrendingNewsAdapter(this@HealthFragment, list)

        binding.rvTopTen.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvTopTen.adapter = TrendingNewsAdapter(this@HealthFragment, list)

        binding.rvRecentUpdates1.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentUpdates1.adapter = ChannelAdapter(this@HealthFragment, list)

        binding.rvRecentUpdates2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentUpdates2.adapter = RecommendedAdapter(this@HealthFragment, list)

    }

}