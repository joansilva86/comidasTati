package com.ukuapps.comidastati.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayOut())
    }
    abstract fun getLayOut():Int

    fun toast(msj:String){
        Toast.makeText(this, msj, Toast.LENGTH_LONG).show()
    }


}