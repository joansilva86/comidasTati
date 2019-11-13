package com.example.comidastati.presentation.detail

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import com.example.comidastati.R
import com.example.comidastati.ComidasTatiApp
import com.example.comidastati.presentation.base.BaseActivity
import com.example.comidastati.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity() , DetailView{

    @Inject
    lateinit var presenter: DetailPresenter

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun getLayOut(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ComidasTatiApp).getAppContent().inject(this)
        btnGetOrder.setOnClickListener { goToMakePedido() }
    }

    override fun showError(msj: String) {
        toast(msj)
    }

    override fun showFood(model: DetailView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMakePedido() {
        val isAppInstalled = appInstalledOrNot("com.whatsapp")
        val num = getString(R.string.phone)
        if (isAppInstalled) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=$num"))
            startActivity(intent)
        } else {

        }
    }

    private fun appInstalledOrNot(uri: String): Boolean {
        val pm = packageManager
        return try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    override fun goBack() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun newFood() {
        var model = DetailModel("fasd","we",12,123,11)
        presenter.newFood(model)
    }

    override fun nameEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ingredientesEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun priceEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun timeEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun newFoodSucced() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
