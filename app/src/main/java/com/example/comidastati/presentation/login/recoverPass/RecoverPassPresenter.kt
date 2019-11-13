package com.example.comidastati.presentation.login.recoverPass

import android.util.Patterns
import com.example.comidastati.domain.login.LoginInteractorI
import com.example.comidastati.domain.login.RecoverPasswordException
import com.example.comidastati.presentation.base.BasePresenter
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
                interactor.recoverPassword(mail)
                view?.showRecoverSucced()
                view?.goToSignIn()

            } catch (ex: RecoverPasswordException) {
                view?.showError(ex.toString())
            }
        }
    }
}