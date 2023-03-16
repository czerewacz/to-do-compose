package com.example.to_do_list.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_do_list.navigation.destinations.listComposable
import com.example.to_do_list.navigation.destinations.splashComposable
import com.example.to_do_list.navigation.destinations.taskComposable
import com.example.to_do_list.ui.viewmodels.SharedViewModel
import com.example.to_do_list.util.Constants.LIST_SCREEN
import com.example.to_do_list.util.Constants.SPLASH_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
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