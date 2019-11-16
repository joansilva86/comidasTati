package com.ukuapps.comidastati.domain.main

import com.google.firebase.database.*
import com.ukuapps.comidastati.presentation.detail.DetailModel
import com.ukuapps.comidastati.presentation.main.RecyclerModel
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class MainInteractorImp : MainInteractorI {

    var unobjeto: DetailModel? = null

    var list = ArrayList<RecyclerModel>()
    var database = FirebaseDatabase.getInstance()
    var dbReference = database.getReference()

    init {

        dbReference = database.reference.child("comidas")
    }

    override fun getListFood(list: ArrayList<RecyclerModel>) {
        this.list = list
        dbReference.addValueEventListener(listener)

    }

    var listener = object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            if (dataSnapshot.exists()) {
                //unobjeto = dataSnapshot.getValue(DetailModel::class.java)
                for (h in dataSnapshot.children) {
                    unobjeto = h.getValue(DetailModel::class.java)

                    var vistaObjeto = convertir(unobjeto)
                    list.add(vistaObjeto)
                }

            }


        }

    }

    fun convertir(detail: DetailModel?): RecyclerModel {
        return RecyclerModel(detail!!.name)
    }

    override fun updateFood(model: DetailModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFood(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFoods(list: ArrayList<RecyclerModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun newFood(model: DetailModel): Unit =
        suspendCancellableCoroutine { continues ->

            //val userDB = dbReference.child("comidas")
            model.id = dbReference.push().key!!
            dbReference.child(model.id).setValue(model).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continues.resume(Unit)
                } else {
                    continues.resumeWithException(ExceptionNewFood(task.exception.toString()))

                }
            }
        }
    //userDB.child("Ingredientes").setValue(model.ingredientes)
}