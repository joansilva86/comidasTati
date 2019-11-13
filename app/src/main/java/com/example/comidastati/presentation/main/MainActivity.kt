package com.example.comidastati.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comidastati.ComidasTatiApp
import com.example.comidastati.R
import com.example.comidastati.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
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
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ComidasTatiApp).getAppContent().inject(this)
        recycler.adapter = CustomAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun showList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(msj: String) {
        toast(msj)
    }

}
