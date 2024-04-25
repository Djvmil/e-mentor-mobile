package com.djvmil.entretienmentor.presentation.ui.auth.login.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.djvmil.entretienmentor.presentation.ui.auth.login.LoginScreen
import com.djvmil.entretienmentor.designsystem.navigation.Destinations
import com.djvmil.entretienmentor.designsystem.navigation.NavigationHelpers

fun NavGraphBuilder.login(
    navActions: NavigationHelpers
) {
    composable(Destinations.LOGIN_ROUTE, enterTransition = {
        return@composable fadeIn(tween(1000))
    }, exitTransition = {
        return@composable slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
        )
    }, popEnterTransition = {
        return@composable slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.End, tween(700)
        )
    }) {
        LoginScreen(
            openDashboard = {
                navActions.navigateUp()
            }


        )
    }
}

fun NavigationHelpers.navigateToLogin() {
    navController.navigate(Destinations.LOGIN_ROUTE)
}