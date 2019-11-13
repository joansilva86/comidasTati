package com.example.comidastati.presentation.login.signIn

import android.util.Patterns

data class SignInModel(var email:String, var password:String) {
    private var p = Patterns.EMAIL_ADDRESS
    var isValid: Boolean = false
        get() {
            return p.matcher(email).matches() && !password.isEmpty()
        }
    var emailIsValid: Boolean = false
    get() {
        return p.matcher(email).matches()
    }
}