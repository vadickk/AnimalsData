package com.egorsigolaev.animalsdata.application

import android.app.Application
import com.egorsigolaev.animalsdata.di.AnimalsDataModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AnimalsDataApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(AnimalsDataModules)
        }
    }
}