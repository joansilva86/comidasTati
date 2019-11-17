package com.ukuapps.comidastati.presentation.di

import com.ukuapps.comidastati.presentation.detail.DetailActivity
import com.ukuapps.comidastati.presentation.login.newAccount.NewAccountActivity
import com.ukuapps.comidastati.presentation.login.recoverPass.RecoverPassActivity
import com.ukuapps.comidastati.presentation.login.signIn.SignInActivity
import com.ukuapps.comidastati.presentation.main.MainActivity
import com.ukuapps.comidastati.presentation.splash.SplashActivity
import dagger.Component

@Component(modules=[PresentationModule::class])
interface PresentationComponent {
    fun inject(signInActivity: SignInActivity)
    fun inject(recoverPassActivity: RecoverPassActivity)
    fun inject(newAccountActivity: NewAccountActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: DetailActivity)
    fun inject(splashActivity: SplashActivity)
}