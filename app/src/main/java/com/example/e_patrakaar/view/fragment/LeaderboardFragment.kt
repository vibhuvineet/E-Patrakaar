package com.example.e_patrakaar.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_patrakaar.databinding.FragmentLeaderboardBinding
import com.example.e_patrakaar.view.adapter.LeaderboardPagerViewAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LeaderboardFragment : Fragment() {

    private var binding: FragmentLeaderboardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLeaderboardBinding.inflate(inflater, container, false)

        val tabLayout = binding?.tabLayout
        val viewPager2 = binding?.viewPager2

        val adapter =
            LeaderboardPagerViewAdapter(requireActivity().supportFragmentManager, lifecycle)

        viewPager2?.adapter = adapter

        TabLayoutMediator(tabLayout!!, viewPager2!!) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Sports"
                }
                1 -> {
                    tab.text = "Health"
                }
                2 -> {
                    tab.text = "Entertainment"
                }
                3 -> {
                    tab.text = "Science"
                }
                4 -> {
                    tab.text = "Technology"
                }
            }
        }.attach()

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}