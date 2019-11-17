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

    private var otroListener: ListenerListFood? = null

    override fun getListFood(list: ArrayList<RecyclerModel>, listener: ListenerListFood) {
        this.list = list
        this.otroListener = listener!!
        dbReference.addValueEventListener(listener2)
    }

    var listener2 = object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            if (dataSnapshot.exists()) {
                //unobjeto = dataSnapshot.getValue(DetailModel::class.java)
                for (h in dataSnapshot.children) {
                    var unobjeto = h.getValue(DetailModel::class.java)

                    var vistaObjeto = convertir(unobjeto)
                    list.add(vistaObjeto)
                }
                otroListener?.succed()
            }
        }
    }

    override suspend fun getListFood(list: ArrayList<RecyclerModel>) : Unit = suspendCancellableCoroutine{continuos->

        dbReference.addValueEventListener(object :   ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                continuos.resumeWithException(GetListException("algo Salio mal "))
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    //unobjeto = dataSnapshot.getValue(DetailModel::class.java)
                    for (h in dataSnapshot.children) {
                        var unobjeto = h.getValue(DetailModel::class.java)

                        var vistaObjeto = convertir(unobjeto)
                        list.add(vistaObjeto)
                    }
                    otroListener?.succed()
                }
                continuos.resume(Unit)
            }

        })

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