package com.example.e_patrakaar.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_patrakaar.databinding.CustomCityItemBinding
import com.example.e_patrakaar.model.Collection

class ChannelAdapter(private val fragment: Fragment, private val list: List<Collection>): RecyclerView.Adapter<ChannelAdapter.ViewHolder>() {

    class ViewHolder(view: CustomCityItemBinding) : RecyclerView.ViewHolder(view.root) {
        val text: TextView = view.textView
        val image: ImageView = view.image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CustomCityItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = list[position]
        Glide.with(fragment).load(city.image).circleCrop().into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}