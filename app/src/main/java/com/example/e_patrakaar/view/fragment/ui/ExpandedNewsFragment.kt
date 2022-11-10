@file:Suppress("DEPRECATION")

package com.example.e_patrakaar.view.fragment.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.e_patrakaar.database.entity.RandomNews
import com.example.e_patrakaar.databinding.FragmentExpandedNewsBinding
import com.example.e_patrakaar.viewmodel.RandomNewsViewModel

class ExpandedNewsFragment : Fragment() {

    private lateinit var binding: FragmentExpandedNewsBinding

    //Changes for database
    private lateinit var randomNewsViewModel: RandomNewsViewModel
    private lateinit var progressBar: ProgressDialog

    private lateinit var newsList: ArrayList<RandomNews.Article>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpandedNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Changes for database
        randomNewsViewModel = ViewModelProvider(this)[RandomNewsViewModel::class.java]
        randomNewsViewModel.getNewsFromAPI()
        progressBar = ProgressDialog(requireActivity())
        progressBar.setMessage("Loading news..")
        progressBar.show()
        randomNewsViewModelObserver()

    }


    //Changes for database
    private fun randomNewsViewModelObserver() {

        randomNewsViewModel.randomNewsResponse.observe(
            viewLifecycleOwner
        ) {
            it?.let {
                val random = (0..100).random()
                setRandomNewsResponseInUI(it.articles[random])
                progressBar.dismiss()
            }
        }

        randomNewsViewModel.randomNewsLoadingError.observe(
            viewLifecycleOwner
        ){
            it?.let {

            }
        }
        randomNewsViewModel.loadRandomNews.observe(
            viewLifecycleOwner
        ){
            it?.let {
                if (it){
                    progressBar.show()
                } else {
                    progressBar.dismiss()
                }
            }
        }

    }

    private fun setRandomNewsResponseInUI(article: RandomNews.Article) {

        Glide.with(requireActivity())
            .load(article.urlToImage)
            .centerCrop()
            .into(binding.image)

        binding.title.text = article.title
        binding.description.text = article.description
        binding.time.text = article.publishedAt

    }
}