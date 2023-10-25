package com.egorsigolaev.animalsdata.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.egorsigolaev.animalsdata.navigation.AnimalsDataNavigationRepository

class AnimalsViewModel(
    private val navigationRepository: AnimalsDataNavigationRepository
) : ViewModel(), AnimalsDataNavigationRepository {

    override fun navigateToRandomDogFragment(navController: NavController) {
        navigationRepository.navigateToRandomDogFragment(navController)
    }

    override fun navigateToRandomCatFragment(navController: NavController) {
        navigationRepository.navigateToRandomCatFragment(navController)
    }
}