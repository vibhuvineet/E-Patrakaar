@file:Suppress("DEPRECATION")

package com.example.e_patrakaar.view.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.e_patrakaar.databinding.FragmentExpandedNewsBinding

class ExpandedNewsFragment : Fragment() {

    private lateinit var binding: FragmentExpandedNewsBinding
    private lateinit var newsDetails: com.example.e_patrakaar.model.Collection

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpandedNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRandomNewsResponseInUI()

    }

    private fun setRandomNewsResponseInUI() {

        val args: ExpandedNewsFragmentArgs by navArgs()
        newsDetails = args.expandedNewsHome

        Glide.with(requireActivity())
            .load(newsDetails.image)
            .centerCrop()
            .into(binding.image)

        binding.title.text = newsDetails.title
        binding.description.text = newsDetails.description
        binding.time.text = newsDetails.publishedAt

    }
}