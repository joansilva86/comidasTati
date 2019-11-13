package com.ukuapps.comidastati.presentation.login.signIn

import android.content.Intent
import android.os.Bundle
import com.ukuapps.comidastati.ComidasTatiApp
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.presentation.base.BaseActivity
import com.ukuapps.comidastati.presentation.login.newAccount.NewAccountActivity
import com.ukuapps.comidastati.presentation.login.recoverPass.RecoverPassActivity

//import com.ukuapps.comidastati.presentation.login.newAccount.NewAccountActivity
//import com.ukuapps.comidastati.presentation.login.recoverPass.RecoverPassActivity

import com.ukuapps.comidastati.presentation.main.MainActivity
//import kotlinx.android.synthetic.main.activity_new_account.btnNewAccount
import kotlinx.android.synthetic.main.activity_new_account.txtLayoutMail
import kotlinx.android.synthetic.main.activity_sign_in.*
import javax.inject.Inject

class SignInActivity : BaseActivity(), SignInView {

    @Inject
    lateinit var presenter: SignInPresenter

    override fun getLayOut(): Int {
        return R.layout.activity_sign_in
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

        btnNewAccount.setOnClickListener { goToNewAccount() }
        btnSignIn.setOnClickListener { signIn() }
        btnRecoverPassword.setOnClickListener { goToRecoverPassword() }
    }

    override fun showError(msj: String) {
        toast(msj)
    }

    override fun mailEmpty() {
        txtLayoutMail.error = getString(R.string.mailEmpty)
    }

    override fun passwordEmpty() {
        txtLayoutMail.error = getString(R.string.passwordEmpty)
    }

    override fun emailNoMatch() {
        txtLayoutMail.error = getString(R.string.emailNoMatch)
    }

    override fun signIn() {
        val mail = txtMail.text.toString()
        val pass = txtPass.text.toString()
        val model = SignInModel(mail, pass)
        presenter.signIn(model)
    }

    override fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun goToNewAccount() {
        val intent = Intent(this, NewAccountActivity::class.java)
        startActivity(intent)
    }

    override fun cleanPassword() {
        val intent = Intent(this, RecoverPassActivity::class.java)
        startActivity(intent)
    }

    override fun goToRecoverPassword() {
        val intent = Intent(this, RecoverPassActivity::class.java)
        startActivity(intent)
    }

}
