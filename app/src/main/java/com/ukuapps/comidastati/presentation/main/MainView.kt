package com.ukuapps.comidastati.presentation.main

interface MainView {
    fun showList()
    fun showError(msj : String)
    fun goToNewFood()
    fun goToViewFood()

    fun modeAdmin()
    fun modeUser()

}