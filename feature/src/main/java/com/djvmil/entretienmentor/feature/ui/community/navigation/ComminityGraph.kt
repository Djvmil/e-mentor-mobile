package com.djvmil.entretienmentor.feature.ui.community.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.djvmil.entretienmentor.feature.ui.chat.ChatScreen
import com.djvmil.feature.navigation.Destinations
import com.djvmil.feature.navigation.NavigationHelpers

fun NavGraphBuilder.community(
    navActions: NavigationHelpers
) {
    composable(Destinations.COMMINITY_ROUTE, enterTransition = {
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
        ChatScreen(
            openDashboard = {
                navActions.navigateUp()
            }
        )
    }
}


fun NavigationHelpers.navigateToCommunity() {
    navController.navigate(Destinations.COMMINITY_ROUTE)
}