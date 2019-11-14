package com.ukuapps.comidastati

import android.app.Application
import com.ukuapps.comidastati.presentation.di.DaggerPresentationComponent
import com.ukuapps.comidastati.presentation.di.PresentationComponent
import com.ukuapps.comidastati.presentation.di.PresentationModule

class ComidasTatiApp: Application() {

    private lateinit var appComponent: PresentationComponent
    fun getAppContent() = appComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerPresentationComponent
            .builder()
            .presentationModule(PresentationModule())
            .build()
    }
}