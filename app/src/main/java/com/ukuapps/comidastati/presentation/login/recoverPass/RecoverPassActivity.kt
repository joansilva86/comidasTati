package com.ukuapps.comidastati.presentation.login.recoverPass


import android.os.Bundle
import android.view.View
import com.ukuapps.comidastati.ComidasTatiApp
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_recover_pass.*
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
        btnForget.setOnClickListener { recoverPassword() }
        btnCancel.setOnClickListener { goToSignIn() }
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

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
