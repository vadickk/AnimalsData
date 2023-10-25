package com.egorsigolaev.animalsdata.network.services

import com.egorsigolaev.animalsdata.network.entities.RandomDogImage
import retrofit2.Response
import retrofit2.http.GET

interface RandomDogImageService {

    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): Response<RandomDogImage>

    companion object {
        const val RANDOM_DOG_IMAGE_SERVICE_BASE_URL = "https://dog.ceo/api/"
    }
}