package com.example.notenow.data.source.local

interface TaskDataSource {
    suspend fun saveTask(task: Task)


}