package com.ukuapps.comidastati.presentation.main

import com.ukuapps.comidastati.domain.main.GetListException
import com.ukuapps.comidastati.domain.main.ListenerListFood
import com.ukuapps.comidastati.domain.main.MainException
import com.ukuapps.comidastati.domain.main.MainInteractorI
import com.ukuapps.comidastati.presentation.base.BasePresenter
import com.ukuapps.comidastati.presentation.login.signIn.SignInModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainPresenter @Inject constructor(private val interactor: MainInteractorI) :
    BasePresenter(), CoroutineScope {

    private var view: MainView? = null
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun attach(view: Any) {
        this.view = view as MainView
    }

    override fun detach() {
        this.view = null
    }


    var list = ArrayList<RecyclerModel>()

    fun begin() {
        var user = SignInModel.getInstance()
        if (user.isAdmin) {
            view?.modeAdmin()
        } else {
            view?.modeUser()
        }
        launch {
            try {

                interactor.getListFood(list)
                view?.showList(list)
            } catch (ex: GetListException) {
                view?.showError(ex.toString())
            }
        }
    }

    /*var listener = object : ListenerListFood {
        override fun succed() {
            view?.showList(list)
        }

        override fun failure() {

        }

    }*/

}