package com.ukuapps.comidastati.presentation.login.signIn

import com.ukuapps.comidastati.domain.login.LoginInteractorI
import com.ukuapps.comidastati.domain.login.SignInException
import com.ukuapps.comidastati.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SignInPresenter @Inject constructor(private var interactor: LoginInteractorI) :
    BasePresenter(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private var view: SignInView? = null

    override fun attach(view: Any) {
        this.view = view as SignInView
    }

    override fun detach() {
        view = null
    }

    fun signIn(model: SignInModel) {
        if (validate(model))
            return
        launch {
            try {
                interactor.signIn(model)
                view?.goToMain()
            } catch (ex: SignInException) {
                view?.cleanPassword()
                view?.showError(ex.toString())
            }

        }
    }

    fun validate(model: SignInModel): Boolean {
        if (model.email.isEmpty()) {
            view?.mailEmpty()
        }
        if (!model.emailIsValid) {
            view?.emailNoMatch()
        }
        if (model.password.isEmpty()) {
            view?.passwordEmpty()
        }
        if (!model.isValid)
            return true
        return false

    }
}