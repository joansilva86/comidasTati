package com.example.comidastati.domain.login

import com.example.comidastati.presentation.login.newAccount.NewAccountModel
import com.example.comidastati.presentation.login.signIn.SignInModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


class LoginInteractorImp : LoginInteractorI {

    var auth = FirebaseAuth.getInstance()

    override suspend fun signIn(model: SignInModel):
            Unit = suspendCancellableCoroutine { continues ->
        auth?.signInWithEmailAndPassword(model.email, model.password)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful()) {
                    continues.resume(Unit)
                } else {
                    continues.resumeWithException(SignInException(task.exception.toString()))
                }

            }
    }

    override suspend fun createNewAccount(model: NewAccountModel): Unit =
        suspendCancellableCoroutine { continues ->
            auth.createUserWithEmailAndPassword(model.email, model.pass1)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continues.resume(Unit)
                    } else {
                        continues.resumeWithException(NewAccountException(task.exception.toString()))
                    }
                }
        }

    override suspend fun recoverPassword(email: String): Unit =
        suspendCancellableCoroutine { continues ->
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful()) {
                        continues.resume(Unit)
                    } else {
                        continues.resumeWithException(RecoverPasswordException(task.exception.toString()))
                    }
                }

        }

}