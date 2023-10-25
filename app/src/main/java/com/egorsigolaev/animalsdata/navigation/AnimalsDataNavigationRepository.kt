package com.egorsigolaev.animalsdata.navigation

import androidx.navigation.NavController
import com.egorsigolaev.animalsdata.R

interface AnimalsDataNavigationRepository {

    fun navigateToRandomDogFragment(navController: NavController)

    fun navigateToRandomCatFragment(navController: NavController)

    class Base : AnimalsDataNavigationRepository {

        override fun navigateToRandomDogFragment(navController: NavController) {
            navController.navigate(R.id.actionFromAnimalsFragmentToRandomDogFragment)
        }

        override fun navigateToRandomCatFragment(navController: NavController) {
            navController.navigate(R.id.actionFromAnimalsFragmentToRandomCatFragment)
        }
    }
}