package com.example.e_patrakaar.view.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.FragmentNotificationBinding
import com.example.e_patrakaar.model.Notification
import com.example.e_patrakaar.view.adapter.NotificationAdapter

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var list: List<Notification>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = dummyList()

        binding.rvNotifications.adapter = NotificationAdapter(this@NotificationFragment, list)
        binding.rvNotifications.layoutManager = LinearLayoutManager(requireActivity())

    }

    private fun dummyList(): List<Notification> {
        return listOf(
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification( "","Old news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification("", "Old news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification("","Old news added.", "Sports", "1 min ago."),
            Notification(R.drawable.pic, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
            Notification(R.drawable.archive, "New news added.", "Sports", "1 min ago."),
        )
    }


}