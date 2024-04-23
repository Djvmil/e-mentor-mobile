package com.djvmil.entretienmentor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.data.source.datastore.model.AppSettings
import com.djvmil.entretienmentor.presentation.ui.ScreenUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainActivityViewModel(
    userDataRepository: AppSettingsDataStoreSource
) : ViewModel() {
    val uiState: StateFlow<ScreenUiState<AppSettings?>> = userDataRepository.appSetting().map {
        ScreenUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = ScreenUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )
}
