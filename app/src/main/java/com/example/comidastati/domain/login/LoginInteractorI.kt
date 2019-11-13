package com.example.comidastati.domain.login

import com.example.comidastati.presentation.login.newAccount.NewAccountModel
import com.example.comidastati.presentation.login.signIn.SignInModel

interface LoginInteractorI {
    suspend fun createNewAccount(model :NewAccountModel)
    suspend fun recoverPassword(email:String)
    suspend fun signIn(model: SignInModel)
}