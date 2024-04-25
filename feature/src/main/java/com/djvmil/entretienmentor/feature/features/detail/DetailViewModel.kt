package com.djvmil.entretienmentor.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.core.model.ErrorEM
import com.djvmil.core.model.ResultEM
import com.djvmil.core.model.map
import com.djvmil.domain.usecase.GetCommunityUseCase
import com.djvmil.domain.usecase.UpdateCommunityUseCase
import com.djvmil.entretienmentor.presentation.model.CommunityUiModel
import com.djvmil.entretienmentor.presentation.model.toDomain
import com.djvmil.entretienmentor.presentation.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    val getMovieUseCase: GetCommunityUseCase,
    val updateMovieUseCase: UpdateCommunityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ResultEM<CommunityUiModel, ErrorEM>>(ResultEM.Loading)
    val uiState = _uiState.asStateFlow()

    fun getCommunity(communityId: Int) {
        viewModelScope.launch {
            getMovieUseCase(communityId)
                .flowOn(Dispatchers.IO)
                .catch { throwable ->
                    updateError(throwable)
                }
                .collect { result ->
                    _uiState.value =
                        result.map { it.toUi() }
                }
        }
    }

    fun updateMovie(movie: CommunityUiModel) {
        viewModelScope.launch {
            updateMovieUseCase(movie.toDomain())
        }
    }

    private fun updateLoading(isLoading: Boolean) {
        _uiState.update { ResultEM.Loading }
    }

    private fun updateError(throwable: Throwable) {
        _uiState.update { ResultEM.Failure(
            ErrorEM(
                throwable = throwable
            )
        ) }
    }
}