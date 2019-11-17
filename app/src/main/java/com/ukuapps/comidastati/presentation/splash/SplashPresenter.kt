package com.ukuapps.comidastati.presentation.splash

import com.ukuapps.comidastati.domain.login.LoginInteractorI
import com.ukuapps.comidastati.presentation.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(private var interactor: LoginInteractorI) :
    BasePresenter() {
    private var view: SplashView? = null
    override fun attach(view: Any) {
        this.view = view as SplashView
    }

    override fun detach() {
        this.view = null
    }

    fun isLoged(): Boolean {
        //ERICK
        return false
    }

    fun begin() {
        view?.goToApplication()
    }
}