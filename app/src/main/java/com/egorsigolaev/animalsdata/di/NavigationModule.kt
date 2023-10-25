package com.egorsigolaev.animalsdata.di

import com.egorsigolaev.animalsdata.navigation.AnimalsDataNavigationRepository
import org.koin.dsl.module

val NavigationModule = module {
    single<AnimalsDataNavigationRepository> { AnimalsDataNavigationRepository.Base() }
}