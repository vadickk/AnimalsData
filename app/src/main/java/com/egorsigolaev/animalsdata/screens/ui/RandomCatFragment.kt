package com.egorsigolaev.animalsdata.screens.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorsigolaev.animalsdata.R
import com.egorsigolaev.animalsdata.databinding.FragmentRandomCatBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class RandomCatFragment : Fragment() {
    private val binding by lazy { FragmentRandomCatBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAndSetCat()

        binding.btnGenerateRandomCatImage.setOnClickListener {
            getAndSetCat()
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getAndSetCat() {
        binding.btnGenerateRandomCatImage.startAnimation()
        Picasso.get()
            .load("https://cataas.com/cat")
            .placeholder(R.drawable.cat_placeholder)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(binding.ivCat, object : Callback {
                override fun onSuccess() {
                    Log.d("MyLog", "onSuccess")
                    binding.btnGenerateRandomCatImage.stopAnimation()
                    binding.btnGenerateRandomCatImage.revertAnimation()
                }

                override fun onError(e: Exception?) {
                    Log.d("MyLog", "onError")
                    binding.btnGenerateRandomCatImage.stopAnimation()
                    binding.btnGenerateRandomCatImage.revertAnimation()
                }
            })
    }
}