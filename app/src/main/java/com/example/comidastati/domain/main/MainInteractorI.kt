package com.example.comidastati.domain.main

import com.example.comidastati.presentation.detail.DetailModel
import com.example.comidastati.presentation.main.RecyclerModel

interface MainInteractorI {
    fun newFood(model: DetailModel)
    fun updateFood(model: DetailModel)
    fun deleteFood(id:Int)
    fun getFoods(list: ArrayList<RecyclerModel>)
}