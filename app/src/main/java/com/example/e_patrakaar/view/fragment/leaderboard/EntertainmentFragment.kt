package com.example.e_patrakaar.view.fragment.leaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.databinding.FragmentEntertainmentBinding

import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.adapter.ChannelAdapter
import com.example.e_patrakaar.view.adapter.RecommendedAdapter
import com.example.e_patrakaar.view.adapter.TrendingNewsAdapter


class EntertainmentFragment : Fragment() {

    private lateinit var binding: FragmentEntertainmentBinding
    private lateinit var list: List<Collection>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntertainmentBinding.inflate(inflater, container, false)
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
        binding.rvEnterTop.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvEnterTop.adapter = TrendingNewsAdapter(this@EntertainmentFragment, list)

        binding.rvLatestEnter.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestEnter.adapter = TrendingNewsAdapter(this@EntertainmentFragment, list)

        binding.rvLatestEnter2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvLatestEnter2.adapter = TrendingNewsAdapter(this@EntertainmentFragment, list)

        binding.rvTopTenEnter.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvTopTenEnter.adapter = TrendingNewsAdapter(this@EntertainmentFragment, list)

        binding.rvRecentEnterUpdates1.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentEnterUpdates1.adapter = ChannelAdapter(this@EntertainmentFragment, list)

        binding.rvRecentEnterUpdates2.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        binding.rvRecentEnterUpdates2.adapter = RecommendedAdapter(this@EntertainmentFragment, list)

    }

}