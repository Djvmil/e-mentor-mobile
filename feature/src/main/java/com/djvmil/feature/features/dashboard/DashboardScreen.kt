package com.djvmil.entretienmentor.presentation.ui.dashboard

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.djvmil.common.bottombar.AnimatedNavigationBar
import com.djvmil.common.bottombar.animation.balltrajectory.Straight
import com.djvmil.common.bottombar.animation.indendshape.StraightIndent
import com.djvmil.common.bottombar.animation.indendshape.shapeCornerRadius
import com.djvmil.entretienmentor.presentation.ui.dashboard.colorButtons.ColorButton
import com.djvmil.entretienmentor.designsystem.navigation.NavGraph
import com.djvmil.entretienmentor.designsystem.navigation.NavigationHelpers
import com.djvmil.entretienmentor.presentation.ui.blog.navigation.navigateToBlog
import com.djvmil.entretienmentor.presentation.ui.chat.navigation.navigateToChat
import com.djvmil.entretienmentor.presentation.ui.community.navigation.navigateToCommunity
import com.djvmil.entretienmentor.presentation.ui.home.navigation.navigateToHome
import com.djvmil.feature.features.profile.navigation.navigateToProfile
import com.djvmil.entretienmentor.designsystem.theme.EntretienMentorTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(
    darkTheme: Boolean = false,
    androidTheme: Boolean = false,
    isAuth: Boolean = false,
) {
    val navController: NavHostController = rememberNavController()
    val navActions: NavigationHelpers = remember(navController) {
        NavigationHelpers(navController)
    }

    EntretienMentorTheme(
        useDarkTheme = darkTheme,
        useAndroidTheme = androidTheme
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
            Scaffold(
                topBar = {
                    /*TopAppBar(
                        title = {
                            Box(Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center) {
                                Text(text = "Entretien Mentor", fontWeight = FontWeight.Bold)
                            }

                        },
                        Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        navigationIcon = {
                            IconButton(onClick = {  }) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back icon" )
                            }

                        },
                        actions = {

                            IconButton(onClick = {  }) {
                                Icon(painter = painterResource(id = R.drawable.outline_bell), contentDescription = "Notification icon" )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.White
                        )
                    )*/
                },
                bottomBar = {
                    if(isAuth) ColorButtonNavBar(navActions)
                },
                modifier = Modifier,
                snackbarHost = {},
                floatingActionButton = {},
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            //.background(Color.LightGray)
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 40.dp)

                    ) {
                        NavGraph(
                            navController = navController,
                            navActions = navActions,
                            isAuth = isAuth
                        )
                    }
                }
            )
        }
    }

}

@Composable
fun ColorButtonNavBar(navActions: NavigationHelpers) {
    var selectedItem by remember { mutableStateOf(0) }
    var prevSelectedIndex by remember { mutableStateOf(0) }

    AnimatedNavigationBar(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .height(70.dp),
        selectedIndex = selectedItem,

        ballColor = Color.White,
        cornerRadius = shapeCornerRadius(25.dp),
        ballAnimation = Straight(
            spring(dampingRatio = 0.6f, stiffness = Spring.StiffnessVeryLow)
        ),
        indentAnimation = StraightIndent(
            indentWidth = 56.dp,
            indentHeight = 15.dp,
            animationSpec = tween(1000)
        )
    ) {
        colorButtons.forEachIndexed { index, it ->
            ColorButton(
                modifier = Modifier.fillMaxSize(),
                prevSelectedIndex = prevSelectedIndex,
                selectedIndex = selectedItem,
                index = index,
                onClick = {
                    prevSelectedIndex = selectedItem
                    selectedItem = index
                    when(selectedItem){
                        0 -> navActions.navigateToHome()
                        1 -> navActions.navigateToChat()
                        2 -> navActions.navigateToBlog()
                        3 -> navActions.navigateToCommunity()
                        4 -> navActions.navigateToProfile()
                    }

                },
                icon = it.icon,
                contentDescription = stringResource(id = it.description),
                animationType = it.animationType,
                background = it.animationType.background
            )
        }
    }
}
