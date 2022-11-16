package com.example.e_patrakaar.view.fragment.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.e_patrakaar.R
import com.example.e_patrakaar.databinding.CustomBottomSheet2Binding
import com.example.e_patrakaar.databinding.FragmentEditProfileBinding
import com.example.e_patrakaar.view.activity.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding
    private lateinit var progressBar: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity()).load(R.drawable.pic).circleCrop().into(binding.ivImage)

        (activity as MainActivity).supportActionBar!!.title = "My Account"

        binding.btnEditPic.setOnClickListener {
            showBottomSheetDialog()
        }

        binding.btnSave.setOnClickListener {
            saveInfo()
        }

    }

    private fun saveInfo() {
        progressBar = ProgressDialog(requireActivity())
        progressBar.setMessage("Saving your info....")
        progressBar.show()
        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.dismiss()
            findNavController().navigateUp()
        }, 1500)
    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(requireActivity())
        val view = CustomBottomSheet2Binding.inflate(layoutInflater)

        view.tvEditPhoto.setOnClickListener {
            Toast.makeText(requireActivity(), "Edit photo is accessed.", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        view.tvRemove.setOnClickListener {
            Toast.makeText(requireActivity(), "Remove photo is accessed.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.setCancelable(true)
        dialog.setContentView(view.root)
        dialog.show()
    }
}