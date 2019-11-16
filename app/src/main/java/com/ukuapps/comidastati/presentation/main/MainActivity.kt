package com.ukuapps.comidastati.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ukuapps.comidastati.ComidasTatiApp
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.presentation.base.BaseActivity
import com.ukuapps.comidastati.presentation.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() , MainView{

    @Inject
    lateinit var presenter: MainPresenter

    override fun getLayOut(): Int {
        return R.layout.activity_main
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        //var list =  (recycler.adapter as CustomAdapter).list
        //var list = ArrayList<RecyclerModel>()
        //presenter.getListFood(list)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ComidasTatiApp).getAppContent().inject(this)

        fab.setOnClickListener { goToNewFood() }
        recycler.adapter = CustomAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun showList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(msj: String) {
        toast(msj)
    }

    override fun goToNewFood() {
        var intent = Intent(this,DetailActivity::class.java)
        startActivity(intent)
    }

    override fun goToViewFood() {
        var intent = Intent(this,DetailActivity::class.java)
        startActivity(intent)
    }

    override fun modeAdmin() {
        //fab.visibility = View.VISIBLE
    }

    override fun modeUser() {
        //fab.visibility = View.GONE
    }

}
