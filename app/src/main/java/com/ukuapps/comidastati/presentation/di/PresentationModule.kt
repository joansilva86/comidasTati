package com.ukuapps.comidastati.presentation.di

import com.ukuapps.comidastati.domain.login.LoginInteractorI
import com.ukuapps.comidastati.domain.login.LoginInteractorImp
import com.ukuapps.comidastati.domain.main.MainInteractorI
import com.ukuapps.comidastati.domain.main.MainInteractorImp
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun provideLoginInteractorImp (): LoginInteractorI = LoginInteractorImp()

    @Provides
    fun provideMainInteractorImp ():  MainInteractorI = MainInteractorImp()
}