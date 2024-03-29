package com.ukuapps.comidastati.presentation.login.signIn

interface SignInView {
    fun showError(msj:String)
    fun mailEmpty()
    fun passwordEmpty()
    fun emailNoMatch()
    fun goToMain()
    fun goToNewAccount()
    fun goToRecoverPassword()
    fun signIn()
    fun cleanPassword()
    fun showProgressBar()
    fun hideProgressBar()

}