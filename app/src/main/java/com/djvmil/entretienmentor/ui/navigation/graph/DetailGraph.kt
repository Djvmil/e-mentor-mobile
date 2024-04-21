package com.djvmil.entretienmentor.ui.navigation.graph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.djvmil.entretienmentor.presentation.presentation.detail.DetailScreen
import com.djvmil.entretienmentor.ui.navigation.Destinations
import com.djvmil.entretienmentor.ui.navigation.DestinationsArgs
import com.djvmil.entretienmentor.ui.navigation.NavigationActions

fun NavGraphBuilder.detail(
    modifier: Modifier,
    navActions: NavigationActions
) {
    composable(
        Destinations.DETAIL_ROUTE,
        arguments = listOf(
            navArgument(DestinationsArgs.MOVIE_DETAIL_ID_ARG) { type = NavType.IntType }
        ), enterTransition = {
            return@composable fadeIn(tween(1000))
        }, exitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
            )
        }, popEnterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(700)
            )
        }
    ) { entry ->
        DetailScreen(
            modifier = modifier,
            movieId = entry.arguments?.getInt(DestinationsArgs.MOVIE_DETAIL_ID_ARG)!!,
            onBackClicked = {
                navActions.navigateToHome()
            }
        )
    }
}