package com.example.comidastati.presentation.di

import com.example.comidastati.presentation.detail.DetailActivity
import com.example.comidastati.presentation.login.newAccount.NewAccountActivity
import com.example.comidastati.presentation.login.recoverPass.RecoverPassActivity
import com.example.comidastati.presentation.login.signIn.SignInActivity
import com.example.comidastati.presentation.main.MainActivity
import dagger.Component

@Component(modules=[PresentationModule::class])
interface PresentationComponent {
    fun inject(signInActivity: SignInActivity)
    fun inject(recoverPassActivity: RecoverPassActivity)
    fun inject(newAccountActivity: NewAccountActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: DetailActivity)
}