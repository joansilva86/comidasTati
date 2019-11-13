package com.example.comidastati.presentation.base

abstract class BasePresenter {
    abstract fun attach(view: Any)
    abstract fun detach()
}