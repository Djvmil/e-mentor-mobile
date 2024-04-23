package com.djvmil.entretienmentor.presentation.ui


sealed class ScreenUiState<out T> {
    object Loading : ScreenUiState<Nothing>()

    data class Success<out T>(val data: T) : ScreenUiState<T>()

    data class Failure(val error: Throwable) : ScreenUiState<Nothing>()

    val isLoading get() = this is Loading
    val isFail get() = this is Failure
    val valueOrNull get() = (this as? Success)?.data
}
