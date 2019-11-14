package com.ukuapps.comidastati.presentation.login.recoverPass

import android.util.Patterns
import com.ukuapps.comidastati.domain.login.LoginInteractorI
import com.ukuapps.comidastati.domain.login.RecoverPasswordException
import com.ukuapps.comidastati.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RecoverPassPresenter
@Inject constructor(private val interactor: LoginInteractorI) :
    BasePresenter(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private var view: RecoverPassView? = null
    override fun attach(view: Any) {
        this.view = view as RecoverPassView
    }

    override fun detach() {
        view = null
    }

    fun recoverPassword(mail: String) {
        val patterns = Patterns.EMAIL_ADDRESS
        if (mail.isEmpty()) {
            view?.empyEmail()
            return
        }
        if (!patterns.matcher(mail).matches()) {
            view?.noMatchEmail()
            return
        }
        launch {
            try {
                view?.showProgressBar()
                interactor.recoverPassword(mail)
                view?.showRecoverSucced()
                view?.goToSignIn()
                view?.hideProgressBar()

            } catch (ex: RecoverPasswordException) {
                view?.showError(ex.toString())
                view?.hideProgressBar()
            }
        }
    }
}