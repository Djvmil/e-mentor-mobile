package com.djvmil.entretienmentor.presentation.di

import com.djvmil.entretienmentor.presentation.presentation.auth.login.LoginViewModel
import com.djvmil.entretienmentor.presentation.presentation.auth.register.RegisterViewModel
import com.djvmil.entretienmentor.presentation.presentation.detail.DetailViewModel
import com.djvmil.entretienmentor.presentation.presentation.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val featureModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { RegisterViewModel(get(), get(named("IODispatcher"))) }
    viewModel { LoginViewModel(get(), get(named("IODispatcher"))) }

    single(named("IODispatcher")) {
        Dispatchers.IO
    }

    single(named("MainDispatcher")) {
        Dispatchers.Main
    }

    single(named("DefaultDispatcher")) {
        Dispatchers.Default
    }

}