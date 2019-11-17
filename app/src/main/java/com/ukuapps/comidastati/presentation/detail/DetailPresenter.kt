package com.ukuapps.comidastati.presentation.detail

import android.content.Intent
import android.net.Uri
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.domain.main.ExceptionNewFood
import com.ukuapps.comidastati.domain.main.MainInteractorI
import com.ukuapps.comidastati.presentation.base.BasePresenter
import com.ukuapps.comidastati.presentation.login.signIn.SignInModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailPresenter @Inject constructor(private val interactor: MainInteractorI) :
    BasePresenter(), CoroutineScope {

    var job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var view: DetailView? = null
    override fun attach(view: Any) {
        this.view = view as DetailView
    }

    override fun detach() {
        this.view = null
    }

    fun begin(){
        var user = SignInModel.getInstance()
        if (user.isAdmin) {
            view?.modeAdmin()
        } else {
            view?.modeUser()
        }
    }

    fun newFood(model: DetailModel) {

        /*if (validate(model))
            return*/
        view?.showProgressBar()
        launch {
            try {

                interactor.newFood(model)
                view?.newFoodSucced()
                view?.goBack()
                view?.hideProgressBar()
            } catch (ex: ExceptionNewFood) {
                view?.showError(ex.toString())
                view?.hideProgressBar()
            }
        }

    }

    fun updateFood(model: DetailModel) {
        if (validate(model))
            return
        launch {
            try {
                interactor.updateFood(model)
                view?.newFoodSucced()
                view?.goBack()
            } catch (ex: ExceptionNewFood) {
                view?.showError(ex.toString())
            }
        }

    }

    fun validate(model: DetailModel): Boolean {
        if (model.name.isEmpty()) {
            view?.nameEmpty()
        }
        if (model.ingredientes.isEmpty())
            view?.ingredientesEmpty()
        if (model.price == 0)
            view?.priceEmpty()
        if (model.time == 0)
            view?.timeEmpty()

        //return !model.isValid
        return true
    }

    fun makePedido(num : String){

    }
}