package com.example.notenow.data.source.local

import androidx.lifecycle.LiveData

interface TaskDataSource {
    suspend fun saveTask(task: Task)
     fun getAllTasks(): LiveData<List<Task>>



}