package com.djvmil.entretienmentor.presentation.presentation.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel()  {

fun login()= viewModelScope.launch {

    loginUseCase.invoke(AuthRequest(username = "admin@em.com", password = "12384")).collect{

        when(it){
            is ResultEM.Success ->  Log.e("TAG", "login: "+ it.value.data)
            is ResultEM.Failure ->  Log.e("TAG", "login: ", it.error.throwable)
            is ResultEM.Loading ->  Log.e("TAG", "login: "+"Loading")
        }

    }
}


}