package com.djvmil.entretienmentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.djvmil.core.network.NetworkMonitor
import com.djvmil.data.source.datastore.model.AppSettings
import com.djvmil.data.source.datastore.model.AppTheme
import com.djvmil.entretienmentor.presentation.presentation.ScreenUiState
import com.djvmil.entretienmentor.presentation.presentation.dashboard.DashboardScreen
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val networkMonitor: NetworkMonitor by inject()

    val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState: ScreenUiState<AppSettings?> by mutableStateOf(ScreenUiState.Loading)

        // Update the uiState
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach {
                        uiState = it
                    }.collect()
            }
        }

        // Keep the splash screen on-screen until the UI state is loaded. This condition is
        // evaluated each time the app needs to be redrawn so it should be fast to avoid blocking
        // the UI.
        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                ScreenUiState.Loading -> true
                is ScreenUiState.Success -> false
                else -> true
            }
        }

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val darkTheme = shouldUseDarkTheme(uiState)
            val androidTheme = shouldUseAndroidTheme(uiState)
            DashboardScreen( darkTheme = darkTheme, androidTheme = androidTheme, isAuth = false)
        }
    }
}


/**
 * Returns `true` if the Android theme should be used, as a function of the [uiState].
 */
@Composable
private fun shouldUseAndroidTheme(
    uiState: ScreenUiState<AppSettings?>,
): Boolean = when (uiState) {
    ScreenUiState.Loading -> false
    is ScreenUiState.Success -> when (uiState.data?.theme) {
        AppTheme.default() -> false
        else -> true
    }
    else -> false
}

/**
 * Returns `true` if dark theme should be used, as a function of the [uiState] and the
 * current system context.
 */
@Composable
private fun shouldUseDarkTheme(
    uiState: ScreenUiState<AppSettings?>,
): Boolean = when (uiState) {
    ScreenUiState.Loading -> isSystemInDarkTheme()
    is ScreenUiState.Success -> when (uiState.data?.theme) {
        AppTheme.FollowSystem -> isSystemInDarkTheme()
        AppTheme.Light -> false
        AppTheme.Dark -> true
        else -> isSystemInDarkTheme()
    }
    else -> isSystemInDarkTheme()
}


