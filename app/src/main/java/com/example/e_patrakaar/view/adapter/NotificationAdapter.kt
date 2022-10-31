package com.example.e_patrakaar.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.CutsomNotificationItemBinding
import com.example.e_patrakaar.model.Notification

class NotificationAdapter(private val fragment: Fragment, private val list: List<Notification>): RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    class ViewHolder(view: CutsomNotificationItemBinding) : RecyclerView.ViewHolder(view.root) {
        val notificationMessage: TextView = view.textView
        val categoryNTime: TextView = view.categoryTime
        val image: ImageView = view.image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CutsomNotificationItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = list[position]
        holder.notificationMessage.text = notification.notificationMessage
        holder.categoryNTime.text = "${notification.category}, ${notification.uploadTime}"
        Glide.with(fragment).load(notification.image).circleCrop().placeholder(R.drawable.comment_outline).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}