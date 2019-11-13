package com.example.comidastati

import android.app.Application
import com.example.comidastati.presentation.di.DaggerPresentationComponent
import com.example.comidastati.presentation.di.PresentationComponent

class ComidasTatiApp: Application() {

    private lateinit var appComponent: PresentationComponent
    fun getAppContent() = appComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerPresentationComponent
            .builder()

            .build()
    }
}