package com.djvmil.entretienmentor.presentation.ui.blog.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.djvmil.entretienmentor.presentation.ui.chat.ChatScreen
import com.djvmil.entretienmentor.designsystem.navigation.Destinations
import com.djvmil.entretienmentor.designsystem.navigation.NavigationHelpers

fun NavGraphBuilder.blog(
    navActions: NavigationHelpers
) {
    composable(Destinations.BLOG_ROUTE, enterTransition = {
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


fun NavigationHelpers.navigateToBlog() {
    navController.navigate(Destinations.BLOG_ROUTE)
}