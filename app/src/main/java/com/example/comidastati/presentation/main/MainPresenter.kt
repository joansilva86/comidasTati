package com.example.comidastati.presentation.main

import com.example.comidastati.domain.main.MainException
import com.example.comidastati.domain.main.MainInteractorI
import com.example.comidastati.presentation.base.BasePresenter
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

    fun begin() {
        launch {
            try {
                //interactor.getFood()
                view?.showList()

            } catch (ex: MainException) {
                view?.showError(ex.toString())
            }
        }
    }

}