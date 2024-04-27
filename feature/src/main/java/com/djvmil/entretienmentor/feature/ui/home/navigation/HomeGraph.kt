package com.djvmil.entretienmentor.feature.ui.home.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.djvmil.entretienmentor.feature.ui.detail.navigation.navigateToDetail
import com.djvmil.entretienmentor.feature.ui.home.HomeScreen
import com.djvmil.entretienmentor.feature.navigation.Destinations
import com.djvmil.entretienmentor.feature.navigation.NavigationHelpers

fun NavGraphBuilder.home(
    navActions: NavigationHelpers
) {
    composable(Destinations.HOME_ROUTE, enterTransition = {
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
        HomeScreen(
            onShowDetail = { movieId ->
                navActions.navigateToDetail(movieId)
            }
        )
    }
}


fun NavigationHelpers.navigateToHome() {
    navController.navigate(Destinations.HOME_ROUTE)
}
