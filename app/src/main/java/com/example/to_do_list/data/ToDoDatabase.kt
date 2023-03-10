package com.example.to_do_list.data

import androidx.room.Database
import com.example.to_do_list.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase {

    abstract fun toDoDao() : ToDoDao
}