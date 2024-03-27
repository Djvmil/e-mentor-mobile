package com.djvmil.entretienmentor.ui.navigation.graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.djvmil.entretienmentor.presentation.presentation.auth.AuthScreen
import com.djvmil.entretienmentor.ui.navigation.Destinations
import com.djvmil.entretienmentor.ui.navigation.NavigationActions

fun NavGraphBuilder.auth(
    modifier: Modifier,
    navActions: NavigationActions
) {
    composable(Destinations.AUTH_ROUTE) {
        AuthScreen(
            navActions
        )
    }
}