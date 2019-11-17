package com.ukuapps.comidastati.presentation.detail

class DetailModel(
    var name: String,
    var ingredientes: String,
    var price: Int,
    var time: Int,
    var id:  String
) {
   /* var isValid: Boolean = false
        get() {
            return ((price != 0)
                    && (time != 0)
                    && name.isNotEmpty()
                    && ingredientes.isNotEmpty())
        }*/
    constructor(): this("","",1,1,"")
}