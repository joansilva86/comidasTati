package com.ukuapps.comidastati.domain.main

import com.ukuapps.comidastati.presentation.detail.DetailModel
import com.ukuapps.comidastati.presentation.main.RecyclerModel

interface MainInteractorI {
    suspend fun newFood(model: DetailModel)
    fun updateFood(model: DetailModel)
    fun deleteFood(id:Int)
    fun getFoods(list: ArrayList<RecyclerModel>)
    suspend fun getListFood(list : ArrayList<RecyclerModel>)
    fun getListFood(list : ArrayList<RecyclerModel>, listener: ListenerListFood)
}

interface ListenerListFood{
    fun succed()
    fun failure()
}