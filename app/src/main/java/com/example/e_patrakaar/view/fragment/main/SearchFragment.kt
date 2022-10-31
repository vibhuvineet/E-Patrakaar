package com.example.e_patrakaar.view.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.FragmentSearchBinding
import com.example.e_patrakaar.model.City
import com.example.e_patrakaar.view.adapter.CityAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var list1: List<City>
    private lateinit var list2: List<City>

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
            City("Delhi", R.drawable.pic),
            City("Bangalore", R.drawable.pic),
            City("Mumbai", R.drawable.pic),
            City("Punjab", R.drawable.pic),
            City("Haryana", R.drawable.pic),
        )
        list2 = listOf(
            City("Delhi", R.drawable.pic),
            City("Bangalore", R.drawable.pic),
            City("Mumbai", R.drawable.pic),
            City("Punjab", R.drawable.pic),
            City("Haryana", R.drawable.pic),
            City("UP", R.drawable.pic),
            City("Bengal", R.drawable.pic),
            City("Bihar", R.drawable.pic),
            City("Kerala", R.drawable.pic),
            )

        binding.rvCities.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

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