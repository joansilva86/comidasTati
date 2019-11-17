package com.ukuapps.comidastati.presentation.detail

interface DetailView {
    fun showError(msj:String)

    fun showFood(model: DetailView)

    fun newFood()
    fun updateFood()
    fun goToMakePedido()
    fun goBack()



    fun nameEmpty()
    fun ingredientesEmpty()
    fun priceEmpty()
    fun timeEmpty()
    fun newFoodSucced()

    fun modeCreate()
    fun modeUpdate()
    fun modeView()

    fun showProgressBar()
    fun hideProgressBar()

    fun modeAdmin()
    fun modeUser()

}