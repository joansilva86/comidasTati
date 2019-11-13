package com.example.comidastati.presentation.di

import com.example.comidastati.domain.login.LoginInteractorI
import com.example.comidastati.domain.login.LoginInteractorImp
import com.example.comidastati.domain.main.MainInteractorI
import com.example.comidastati.domain.main.MainInteractorImp
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun provideLoginInteractorImp (): LoginInteractorI = LoginInteractorImp()

    @Provides
    fun provideMainInteractorImp ():  MainInteractorI = MainInteractorImp()
}