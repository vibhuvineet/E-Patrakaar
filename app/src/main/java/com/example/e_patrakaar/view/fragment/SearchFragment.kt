package com.example.e_patrakaar.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.databinding.FragmentSearchBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.adapter.CityAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var list1: List<Collection>
    private lateinit var list2: List<Collection>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list1 = listOf(
            Collection("one"),
            Collection("two"),
            Collection("three"),
            Collection("four"),
        )
        list2 = listOf(
            Collection("one"),
            Collection("two"),
            Collection("three"),
            Collection("four"),
            Collection("five"),
            Collection("six"),
            Collection("seven"),
            Collection("eight"),
            Collection("nine"),
            Collection("ten"),
        )

        binding.rvCities.layoutManager = StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)

        if (binding.tvViewMore.visibility == View.VISIBLE){
            binding.rvCities.adapter = CityAdapter(this@SearchFragment, list1)
        } else {
            binding.rvCities.adapter = CityAdapter(this@SearchFragment, list2)
        }

        binding.tvViewLess.setOnClickListener {
            binding.tvViewMore.visibility = View.VISIBLE
            binding.tvViewLess.visibility = View.GONE
            binding.rvCities.adapter = CityAdapter(this@SearchFragment, list1)
        }

        binding.tvViewMore.setOnClickListener {
            binding.tvViewLess.visibility = View.VISIBLE
            binding.tvViewMore.visibility = View.GONE
            binding.rvCities.adapter = CityAdapter(this@SearchFragment, list2)
        }

    }
}