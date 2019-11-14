package com.ukuapps.comidastati.presentation.login.newAccount

interface NewAccountView {
    fun nameEmpty()
    fun foodEmpty()
    fun emailEmpty()
    fun emailNoMacth()
    fun passNoMach()
    fun passEmpty()
    fun newAccount()
    fun showNewAccountSucced()
    fun goToSignIn()
    fun showError(msj : String)
    fun showProgressBar()
    fun hideProgressBar()
}