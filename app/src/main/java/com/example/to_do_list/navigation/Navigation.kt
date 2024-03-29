package com.example.to_do_list.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.to_do_list.navigation.destinations.listComposable
import com.example.to_do_list.navigation.destinations.taskComposable
import com.example.to_do_list.ui.viewmodels.SharedViewModel
import com.example.to_do_list.util.Constants.LIST_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        /* splashComposable(
             navigateToListScreen = screen.splash
         )
         */
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}