package com.ukuapps.comidastati.domain.login

import com.ukuapps.comidastati.presentation.login.newAccount.NewAccountModel
import com.ukuapps.comidastati.presentation.login.signIn.SignInModel

interface LoginInteractorI {
    suspend fun createNewAccount(model :NewAccountModel)
    suspend fun recoverPassword(email:String)
    suspend fun signIn(model: SignInModel)
}