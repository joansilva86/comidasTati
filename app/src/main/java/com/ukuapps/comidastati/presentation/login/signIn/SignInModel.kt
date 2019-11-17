package com.ukuapps.comidastati.presentation.login.signIn

import android.util.Patterns

data class SignInModel(var email: String, var password: String) {
    private var p = Patterns.EMAIL_ADDRESS
    var isValid: Boolean = false
        get() {
            return p.matcher(email).matches() && !password.isEmpty()
        }
    var emailIsValid: Boolean = false
        get() {
            return p.matcher(email).matches()
        }

    companion object {
        private var mInstance: SignInModel? = null

        @Synchronized
        fun getInstance(): SignInModel {
            if (mInstance == null) {
                mInstance = SignInModel("", "")
            }
            return mInstance as SignInModel
        }

        fun setInstance(model: SignInModel) {
            mInstance = model
        }
    }

    var isAdmin: Boolean = false
        get() {
            return email == "tati@gmail.com"
        }

}