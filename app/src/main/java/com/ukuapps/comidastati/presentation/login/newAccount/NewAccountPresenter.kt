package com.ukuapps.comidastati.presentation.login.newAccount

import com.ukuapps.comidastati.domain.login.LoginInteractorI
import com.ukuapps.comidastati.domain.login.NewAccountException
import com.ukuapps.comidastati.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class NewAccountPresenter @Inject constructor(private val interactor: LoginInteractorI) :
    BasePresenter() , CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private var view: NewAccountView? = null

    override fun attach(view: Any) {
        this.view = view as NewAccountView
    }

    override fun detach() {
        this.view = null
    }

    fun createNewAccount(model: NewAccountModel) {
        if(validateNewAccount(model)){
            launch{
                try{
                    view?.showProgressBar()
                    interactor.createNewAccount(model)
                    view?.showNewAccountSucced()
                    view?.goToSignIn()
                    view?.hideProgressBar()
                }
                catch(ex : NewAccountException){
                    view?.showError(ex.toString())
                    view?.hideProgressBar()
                }
            }
        }
    }

    fun validateNewAccount(model:NewAccountModel): Boolean{
        if(model.name.isEmpty()){
            view?.nameEmpty()
        }
        if(model.email.isEmpty()){
            view?.emailEmpty()
        }
        if(model.food.isEmpty()){
            view?.foodEmpty()
        }
        if(model.pass1.isEmpty()){
            view?.passEmpty()
        }
        if(model.pass1!=model.pass2){
            view?.passNoMach()
        }
        if(!model.isMailCorrect){
            view?.emailNoMacth()
        }
        return !model.isValid
    }
}