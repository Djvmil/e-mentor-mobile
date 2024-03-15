package com.djvmil.domain.util

interface UseCaseNoInput<Output> {
    suspend operator fun invoke(): Output
}