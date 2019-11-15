package com.ukuapps.comidastati.presentation.detail

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.ukuapps.comidastati.ComidasTatiApp
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.presentation.base.BaseActivity
import com.ukuapps.comidastati.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailView {


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
        btnUpdateFood.setOnClickListener { updateFood() }
        btnCancel.setOnClickListener { goBack() }
        btnNewFood.setOnClickListener { newFood() }
    }

    override fun showError(msj: String) {
        toast(msj)
    }

    override fun showFood(model: DetailView) {

    }

    override fun goToMakePedido() {

        val isAppInstalled = appInstalledOrNot("com.whatsapp")
        val num = getString(R.string.phone)
        if (isAppInstalled) {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=$num"))
            startActivity(intent)
        } else {
            toast(getString(R.string.whatsappNotInstall))
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

        finish()
    }

    override fun newFood() {
        var nameFood = txtNameFood.text.toString()
        var ingredientes = txtIngredientesFood.text.toString()
        var price = txtPrice.text.toString().toInt()
        var time = txtTime.text.toString().toInt()
        var model = DetailModel(nameFood,ingredientes,price,time, 11)
        presenter.newFood(model)
    }

    override fun nameEmpty() {
        txtLayoutNameFood.error = getString(R.string.nameFoodEmpty)
    }

    override fun ingredientesEmpty() {
        txtLayoutIngredientesFood.error = getString(R.string.ingredientesFoodEmpty)
    }

    override fun priceEmpty() {
        txtLayoutPrice.error = getString(R.string.priceEmpty)
    }

    override fun timeEmpty() {
        txtLayoutTime.error = getString(R.string.timeEmpty)
    }

    override fun updateFood() {
        var model = DetailModel("fasd", "we", 12, 123, 11)
        presenter.updateFood(model)
    }

    override fun newFoodSucced() {
        toast(getString(R.string.createFoodSucced))
    }

    override fun modeCreate() {
        btnGetOrder.visibility = View.GONE
        btnNewFood.visibility = View.VISIBLE
        btnUpdateFood.visibility = View.GONE
        btnCancel.visibility = View.VISIBLE
    }

    override fun modeUpdate() {
        btnGetOrder.visibility = View.GONE
        btnNewFood.visibility = View.GONE
        btnUpdateFood.visibility = View.VISIBLE
        btnCancel.visibility = View.VISIBLE
    }

    override fun modeView() {
        btnGetOrder.visibility = View.VISIBLE
        btnNewFood.visibility = View.GONE
        btnUpdateFood.visibility = View.GONE
        btnCancel.visibility = View.VISIBLE
    }

    override fun showProgressBar() {
        progressBar.visibility  = View.VISIBLE
        btnNewFood.visibility = View.GONE
        btnUpdateFood.visibility = View.GONE
    }

    override fun hideProgressBar() {
        progressBar.visibility  = View.GONE

    }
}
