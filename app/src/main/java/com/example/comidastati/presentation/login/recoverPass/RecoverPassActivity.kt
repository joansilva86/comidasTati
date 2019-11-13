package com.example.comidastati.presentation.login.recoverPass


import android.os.Bundle
import com.example.comidastati.ComidasTatiApp
import com.example.comidastati.R
import com.example.comidastati.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_new_account.*
import javax.inject.Inject

class RecoverPassActivity :
    BaseActivity(), RecoverPassView {

    @Inject
    lateinit var presenter: RecoverPassPresenter

    override fun getLayOut(): Int {
        return R.layout.activity_recover_pass
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ComidasTatiApp).getAppContent().inject(this)
    }

    override fun showError(msj: String) {
        toast(msj)
    }

    override fun showRecoverSucced() {
        toast("Mensaje Enviado")
    }

    override fun goToSignIn() {
        finish()
    }

    override fun empyEmail() {
        txtLayoutMail.error = getString(R.string.mailEmpty)
    }

    override fun noMatchEmail() {
        txtLayoutMail.error= getString(R.string.emailNoMatch)
    }

    override fun recoverPassword() {
        presenter.recoverPassword(txtMail.text.toString())
    }
}
