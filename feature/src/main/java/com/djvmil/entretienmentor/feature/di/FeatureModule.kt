package com.djvmil.entretienmentor.feature.di

import com.djvmil.entretienmentor.feature.ui.auth.forgetpassword.ForgetPasswordViewModel
import com.djvmil.entretienmentor.feature.ui.auth.login.LoginViewModel
import com.djvmil.entretienmentor.feature.ui.auth.register.RegisterViewModel
import com.djvmil.entretienmentor.feature.ui.detail.DetailViewModel
import com.djvmil.entretienmentor.feature.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { RegisterViewModel(get(), get()) }
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { ForgetPasswordViewModel(get(), get(), get(), get()) }

}