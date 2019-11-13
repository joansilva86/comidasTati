package com.example.comidastati.presentation.login.recoverPass

interface RecoverPassView {
    fun showError(msj:String)
    fun showRecoverSucced()
    fun goToSignIn()
    fun empyEmail()
    fun noMatchEmail()
    fun recoverPassword()
}