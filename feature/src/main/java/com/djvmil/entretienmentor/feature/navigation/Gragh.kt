package com.djvmil.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.djvmil.entretienmentor.presentation.ui.auth.auth.navigation.auth
import com.djvmil.feature.features.auth.forgetpassword.navigation.forgetPassword
import com.djvmil.entretienmentor.presentation.ui.blog.navigation.blog
import com.djvmil.entretienmentor.presentation.ui.chat.navigation.chat
import com.djvmil.entretienmentor.presentation.ui.community.navigation.comminity
import com.djvmil.entretienmentor.presentation.ui.detail.navigation.detail
import com.djvmil.entretienmentor.presentation.ui.home.navigation.home
import com.djvmil.entretienmentor.presentation.ui.auth.login.navigation.login
import com.djvmil.feature.features.profile.navigation.profile
import com.djvmil.entretienmentor.presentation.ui.auth.register.navigation.register

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navActions: NavigationHelpers = remember(navController) {
        NavigationHelpers(navController)
    },
    isAuth: Boolean,
) {
    val startDestination: String = if(isAuth) Destinations.HOME_ROUTE else Destinations.AUTH_ROUTE
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        auth(
            navActions = navActions
        )
        login(
            navActions = navActions
        )

        register(
            navActions = navActions
        )
        forgetPassword(
            navActions = navActions
        )

        home(
            navActions = navActions
        )

        detail(
            navActions = navActions
        )

        blog(
            navActions = navActions
        )

        comminity(
            navActions = navActions
        )

        chat(
            navActions = navActions
        )

        profile(
            navActions = navActions
        )
    }
}