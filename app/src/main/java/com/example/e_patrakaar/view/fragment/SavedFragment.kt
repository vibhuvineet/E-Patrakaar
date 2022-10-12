package com.example.e_patrakaar.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_patrakaar.databinding.FragmentSavedBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.adapter.CollectionAdapter

class SavedFragment : Fragment() {

    private lateinit var binding: FragmentSavedBinding
    private lateinit var list: List<Collection>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSavedBinding.inflate(inflater, container, false)

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
        )

        binding.rvCollections.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvCollections.adapter = CollectionAdapter(this@SavedFragment, list)

    }

}