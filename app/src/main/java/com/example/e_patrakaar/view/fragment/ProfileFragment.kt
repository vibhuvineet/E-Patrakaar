package com.example.e_patrakaar.view.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.bumptech.glide.Glide
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.CustomBottomSheetBinding
import com.example.e_patrakaar.databinding.FragmentProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

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

        dialog.setCancelable(true)
        dialog.setContentView(view.root)
        dialog.show()
    }

}