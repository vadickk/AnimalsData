package com.egorsigolaev.animalsdata.screens.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.egorsigolaev.animalsdata.R
import com.egorsigolaev.animalsdata.databinding.FragmentRandomDogBinding
import com.egorsigolaev.animalsdata.screens.viewmodel.RandomDogViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomDogFragment : Fragment() {
    private val binding by lazy { FragmentRandomDogBinding.inflate(layoutInflater) }
    private val randomDogViewModel by viewModel<RandomDogViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomDogViewModel.getRandomDogImage()
        binding.btnGenerateRandomDogImage.startAnimation()

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            randomDogViewModel.imageData.collect {
                if (it.message.isNotBlank()) {
                    withContext(Dispatchers.Main) {
                        Picasso.get()
                            .load(it.message)
                            .placeholder(R.drawable.dog_placeholder)
                            .into(binding.ivDog, object : Callback {
                            override fun onSuccess() {
                                binding.btnGenerateRandomDogImage.stopAnimation()
                                binding.btnGenerateRandomDogImage.revertAnimation()
                            }

                            override fun onError(e: Exception?) {
                                binding.btnGenerateRandomDogImage.stopAnimation()
                                binding.btnGenerateRandomDogImage.revertAnimation()
                            }
                        })
                    }
                }
            }
        }

        binding.btnGenerateRandomDogImage.setOnClickListener {
            binding.btnGenerateRandomDogImage.startAnimation()
            randomDogViewModel.getRandomDogImage()
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}