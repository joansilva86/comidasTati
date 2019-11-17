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
        presenter.begin()
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ComidasTatiApp).getAppContent().inject(this)

        fab.setOnClickListener { goToNewFood() }
        recycler.adapter = CustomAdapter(listenerRecyclerClick)
        recycler.layoutManager = LinearLayoutManager(this)
        modeUser()
    }

    var listenerRecyclerClick = object : ListenerRecyclerClick {
        override fun onClick(id: Int) {
            val intento1 = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(intento1)
        }
    }

    override fun showList(list: ArrayList<RecyclerModel>) {
        (recycler.adapter as CustomAdapter).list = list
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
        fab.show()
    }

    override fun modeUser() {
        fab.hide()
    }

}
