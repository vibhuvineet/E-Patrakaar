package com.example.e_patrakaar.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.CustomCollectionItemBinding
import com.example.e_patrakaar.model.Collection

class CollectionAdapter(private val fragment: Fragment, private val list: List<Collection>): RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {

    class ViewHolder(view: CustomCollectionItemBinding) : RecyclerView.ViewHolder(view.root) {
        val text: TextView = view.textView
        val image: ImageView = view.image
        val text2: TextView = view.textView2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CustomCollectionItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collection = list[position]
        holder.text.text = collection.title
        Glide.with(fragment).load(collection.image).centerCrop().placeholder(R.drawable.add_2).into(holder.image)
        holder.text2.text = collection.description
    }

    override fun getItemCount(): Int {
        return list.size
    }

}