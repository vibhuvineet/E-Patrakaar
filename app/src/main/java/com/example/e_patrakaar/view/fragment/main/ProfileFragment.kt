package com.example.e_patrakaar.view.fragment.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.CustomBottomSheetBinding
import com.example.e_patrakaar.databinding.FragmentProfileBinding
import com.example.e_patrakaar.model.Collection
import com.example.e_patrakaar.view.activity.MainActivity
import com.example.e_patrakaar.view.adapter.CollectionAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var list: List<Collection>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity()).load(R.drawable.pic).circleCrop().into(binding.ivImage)

        list = listOf(
            Collection("Politics", "150 saved posts", R.drawable.pic),
            Collection("Sports", "200 saved posts", R.drawable.home_outline),
            Collection("Animals and Birds", "4 saved posts", R.drawable.pic),
            Collection("National", "23 saved posts", R.drawable.home_outline),
            Collection("International", "46 saved posts", R.drawable.archive),
        )

        binding.rvSaved.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        binding.rvSaved.adapter = CollectionAdapter(this@ProfileFragment, list)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.profile_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.hamburger -> {
                        showBottomSheetDialog()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        (activity as MainActivity).supportActionBar!!.title = binding.tvName.text

    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(requireActivity())
        val view = CustomBottomSheetBinding.inflate(layoutInflater)

        view.tvYourActivity.setOnClickListener {
            Toast.makeText(requireActivity(), "Your activity is accessed.", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        view.tvArchive.setOnClickListener {
            Toast.makeText(requireActivity(), "Archive is accessed.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.tvPolicy.setOnClickListener {
            Toast.makeText(requireActivity(), "Privacy Policy is accessed.", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        view.tvHelp.setOnClickListener {
            Toast.makeText(requireActivity(), "Help is accessed.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.tvTheme.setOnClickListener {
            Toast.makeText(requireActivity(), "Theme is accessed.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.tvSettings.setOnClickListener {
            Toast.makeText(requireActivity(), "Settings is accessed.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.tvLogout.setOnClickListener {
            Toast.makeText(requireActivity(), "Logout is requested.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.setCancelable(true)
        dialog.setContentView(view.root)
        dialog.show()
    }

}