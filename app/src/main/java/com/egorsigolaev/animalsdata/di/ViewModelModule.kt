package com.egorsigolaev.animalsdata.di

import com.egorsigolaev.animalsdata.screens.viewmodel.AnimalsViewModel
import com.egorsigolaev.animalsdata.screens.viewmodel.RandomDogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { RandomDogViewModel(randomDogImageService = get()) }
    viewModel { AnimalsViewModel(navigationRepository = get()) }
}