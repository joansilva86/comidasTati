package com.example.comidastati.presentation.login.newAccount

import android.os.Bundle
import com.example.comidastati.ComidasTatiApp
import com.example.comidastati.R
import com.example.comidastati.presentation.base.BaseActivity
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun foodEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun emailEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun emailNoMacth() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun passNoMach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun passEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNewAccountSucced() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToSignIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(msj: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
