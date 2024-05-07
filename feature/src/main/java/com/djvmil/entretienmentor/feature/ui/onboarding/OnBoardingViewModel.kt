package com.djvmil.entretienmentor.feature.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.entretienmentor.core.common.dispatcher.AppDispatchers
import com.djvmil.entretienmentor.core.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.entretienmentor.core.data.source.datastore.model.StepsStarting
import com.djvmil.entretienmentor.feature.ui.ScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val dispatchers: AppDispatchers,
    private val dataStoreSource: AppSettingsDataStoreSource
) : ViewModel()  {

    fun setStepsApp() = viewModelScope.launch(dispatchers.io){
        dataStoreSource.setStepsStarting(StepsStarting.ON_AUTH_PAGE)
    }



}

