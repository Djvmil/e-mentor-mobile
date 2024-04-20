package com.djvmil.core.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

interface IAppDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}

class AppDispatchers: IAppDispatchers {
    override val io: CoroutineDispatcher = IO
    override val main: CoroutineDispatcher = Main
    override val default: CoroutineDispatcher = Default
}