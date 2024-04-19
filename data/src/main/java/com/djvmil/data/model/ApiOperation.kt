package com.djvmil.data.model


sealed interface ApiOperation<T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure<T>(val exception: Exception) : ApiOperation<T>
}

inline fun <T, R> ApiOperation<T>.mapSuccess(transform: (T) -> R): ApiOperation<R> {
    return when (this) {
        is ApiOperation.Success -> ApiOperation.Success(transform(data))
        is ApiOperation.Failure -> ApiOperation.Failure(exception)
    }
}

inline fun <T> ApiOperation<T>.onFailure(block: (Exception) -> Unit): ApiOperation<T> {
    if (this is ApiOperation.Failure) block(exception)
    return this
}

inline fun <T> ApiOperation<T>.onSuccess(block: (T) -> Unit): ApiOperation<T> {
    if (this is ApiOperation.Success) block(data)
    return this
}