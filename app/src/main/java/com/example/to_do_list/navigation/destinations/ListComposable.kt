package com.example.to_do_list.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.example.to_do_list.ui.screens.list.ListScreen
import com.example.to_do_list.ui.viewmodels.SharedViewModel
import com.example.to_do_list.util.Action
import com.example.to_do_list.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_do_list.util.Constants.LIST_SCREEN
import com.example.to_do_list.util.toAction

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = action) {
            if(action != myAction) {
                myAction = action
                sharedViewModel.updateAction(action)
            }
        }

        val databaseAction = sharedViewModel.action


        ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}