package com.egorsigolaev.animalsdata.screens.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorsigolaev.animalsdata.databinding.FragmentAnimalsBinding
import com.egorsigolaev.animalsdata.screens.viewmodel.AnimalsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalsFragment : Fragment() {
    private val binding by lazy { FragmentAnimalsBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<AnimalsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGetDogsRandomImage.setOnClickListener {
            viewModel.navigateToRandomDogFragment(findNavController())
        }

        binding.btnGetCatsRandomImage.setOnClickListener {
            viewModel.navigateToRandomCatFragment(findNavController())
        }
    }
}