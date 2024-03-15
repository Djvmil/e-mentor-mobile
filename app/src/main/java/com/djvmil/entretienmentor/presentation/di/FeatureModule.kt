package com.djvmil.entretienmentor.presentation.di

import com.djvmil.entretienmentor.presentation.presentation.detail.DetailViewModel
import com.djvmil.entretienmentor.presentation.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get()) }
}