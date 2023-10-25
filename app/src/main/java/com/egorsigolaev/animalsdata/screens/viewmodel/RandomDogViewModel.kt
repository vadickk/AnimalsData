package com.egorsigolaev.animalsdata.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egorsigolaev.animalsdata.network.entities.RandomDogImage
import com.egorsigolaev.animalsdata.network.services.RandomDogImageService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RandomDogViewModel(
    private val randomDogImageService: RandomDogImageService
) : ViewModel() {

    val imageData = MutableStateFlow(RandomDogImage())

    fun getRandomDogImage() {
        viewModelScope.launch {
            val value = randomDogImageService.getRandomDogImage().body()
            value?.let { imageData.emit(it) }
        }
    }
}