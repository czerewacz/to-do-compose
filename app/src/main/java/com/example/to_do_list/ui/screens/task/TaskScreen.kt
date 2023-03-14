package com.example.to_do_list.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.to_do_list.data.models.Priority
import com.example.to_do_list.data.models.ToDoTask
import com.example.to_do_list.ui.viewmodels.SharedViewModel
import com.example.to_do_list.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { sharedViewModel.title.value = it },
                description = description,
                onDescriptionChange = { sharedViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = { sharedViewModel.priority.value = it }
            )
        }
    )
}