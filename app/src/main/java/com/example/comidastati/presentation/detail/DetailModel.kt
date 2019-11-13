package com.example.comidastati.presentation.detail

data class DetailModel(
    var name: String,
    var ingredientes: String,
    var price: Int,
    var time: Int,
    var id:  Int
) {
    var isValid: Boolean = false
        get() {
            return ((price != 0)
                    && (time != 0)
                    && name.isNotEmpty()
                    && ingredientes.isNotEmpty())
        }
}