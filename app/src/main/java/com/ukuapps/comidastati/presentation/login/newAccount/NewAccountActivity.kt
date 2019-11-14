package com.ukuapps.comidastati.presentation.login.newAccount

import android.os.Bundle
import android.view.View
import com.ukuapps.comidastati.ComidasTatiApp
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_new_account.*
import javax.inject.Inject

class NewAccountActivity : BaseActivity() , NewAccountView{


    @Inject
    lateinit var presenter: NewAccountPresenter

    override fun getLayOut(): Int {
        return R.layout.activity_new_account
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
        btnNewAccount.setOnClickListener { newAccount() }
        btnCancel.setOnClickListener { goToSignIn() }
    }

    override fun newAccount() {
        var name = txtName.text.toString()
        var email = txtMail.text.toString()
        var pas1 = txtPass.text.toString()
        var pas2 = txtPass2.text.toString()
        var food =  txtFood.text.toString()
        var model = NewAccountModel(name,email, pas1,pas2, food)
        presenter.createNewAccount(model)
    }

    override fun nameEmpty() {
        txtLayoutLastName.error = getString(R.string.nameEmpty)
    }

    override fun foodEmpty() {
        txtLayoutFood.error = getString(R.string.foodEmpty)
    }

    override fun emailEmpty() {
        txtLayoutMail.error   = getString(R.string.mailEmpty)
    }

    override fun emailNoMacth() {
        txtLayoutMail.error = getString(R.string.emailNoMatch)
    }

    override fun passNoMach() {
        txtLayoutMail.error = getString(R.string.passwordNoMatch)
    }

    override fun passEmpty() {
        txtLayoutPass.error = getString(R.string.passwordEmpty)
    }

    override fun showNewAccountSucced() {
        toast(getString(R.string.new_account_succed))
        finish()
    }

    override fun goToSignIn() {
        finish()
    }

    override fun showError(msj: String) {
        toast(msj)
    }
    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility  = View.GONE
    }

}
