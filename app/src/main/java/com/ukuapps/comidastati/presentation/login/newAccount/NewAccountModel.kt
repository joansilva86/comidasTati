package com.ukuapps.comidastati.presentation.login.newAccount

import android.util.Patterns

data class NewAccountModel(
    var name: String, var email: String
    , var pass1: String
    , var pass2: String
    , var food: String
) {
    var p = Patterns.EMAIL_ADDRESS
    var isValid : Boolean = true
    get() {
        return (email.isEmpty() &&
                name.isEmpty() &&
                pass1.isEmpty() &&
                pass2.isEmpty() &&
                (pass1 == pass2) &&
                p.matcher(email).matches()
                )
    }
    var isMailCorrect : Boolean = true
    get (){
        return p.matcher(email).matches()
    }

}