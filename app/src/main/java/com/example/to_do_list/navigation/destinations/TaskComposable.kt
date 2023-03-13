package com.example.to_do_list.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_do_list.util.Action
import com.example.to_do_list.util.Constants.TASK_ARGUMENT_KEY
import com.example.to_do_list.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToTaskScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}