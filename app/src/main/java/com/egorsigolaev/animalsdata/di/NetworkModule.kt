package com.egorsigolaev.animalsdata.di

import com.egorsigolaev.animalsdata.network.services.RandomDogImageService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {
    single<RandomDogImageService> {
        Retrofit.Builder()
            .baseUrl(RandomDogImageService.RANDOM_DOG_IMAGE_SERVICE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomDogImageService::class.java)
    }
}