package com.djvmil.entretienmentor.presentation.ui.auth.forgetpassword

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.core.dispatcher.AppDispatchers
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.domain.usecase.GetCommunityUseCase
import com.djvmil.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class ForgetPasswordViewModel(
    private val loginUseCase: LoginUseCase,
    private val getMovieUseCase: GetCommunityUseCase,
    private val dispatchers: AppDispatchers,
    private val dataStoreSource: AppSettingsDataStoreSource
) : ViewModel()  {

fun login() = viewModelScope.launch(dispatchers.io) {

    loginUseCase.invoke(AuthRequest(username = "admin@em.com", password = "1234")).collect{}
    getMovieUseCase.invoke(1)
}
    fun login1() = viewModelScope.launch(dispatchers.io) {
        dataStoreSource.isLogin().collect{
            Log.e("TAG", "isLogin: $it")
        }

    }
    fun login2() = viewModelScope.launch(dispatchers.io) {
        dataStoreSource.appSetting().collect{
            Log.e("TAG", "appSetting: $it")

        }

    }


}