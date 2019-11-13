package com.ukuapps.comidastati.presentation.detail

interface DetailView {
    fun showError(msj:String)
    fun showFood(model: DetailView)
    fun goToMakePedido()
    fun goBack()
    fun newFood()
    fun nameEmpty()
    fun ingredientesEmpty()
    fun priceEmpty()
    fun timeEmpty()
    fun newFoodSucced()

}