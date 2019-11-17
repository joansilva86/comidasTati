package com.ukuapps.comidastati.presentation.main

import java.util.ArrayList

interface MainView {
    fun showList(list: ArrayList<RecyclerModel>)
    fun showError(msj : String)
    fun goToNewFood()
    fun goToViewFood()

    fun modeAdmin()
    fun modeUser()

}