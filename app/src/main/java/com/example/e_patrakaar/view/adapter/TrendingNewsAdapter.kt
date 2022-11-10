package com.example.e_patrakaar.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.CustomTrendingItemBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.fragment.leaderboard.SportsFragment
import com.example.e_patrakaar.view.fragment.main.HomeFragment

class TrendingNewsAdapter(private val fragment: Fragment, private val list: List<Collection>): RecyclerView.Adapter<TrendingNewsAdapter.ViewHolder>() {

    class ViewHolder(view: CustomTrendingItemBinding) : RecyclerView.ViewHolder(view.root) {
        val text: TextView = view.textView
        val image: ImageView = view.image
        val card: CardView = view.card
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CustomTrendingItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = list[position]
        holder.text.text = news.text1
        holder.card.setOnClickListener {
            when(fragment){
              is HomeFragment -> {
                  fragment.findNavController().navigate(R.id.action_navigation_home_to_navigation_expanded_news)
              }
              is SportsFragment -> {
                  fragment.findNavController().navigate(R.id.action_navigation_leaderboard_to_navigation_expanded_news)
              }
            }
        }
        Glide.with(fragment).load(news.image).centerCrop().into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}