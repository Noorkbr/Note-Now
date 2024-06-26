package com.example.notenow.data.source.local

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DefaultTaskRepository private constructor(application: Application) {
    private val localDataSource: LocalDataSource
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO


    init {
        localDataSource =
            LocalDataSource(TodoDatabase.getInstance(application.applicationContext).taskDao())
    }


    companion object {
        private var repository: DefaultTaskRepository? = null
        fun getInstance(application: Application): DefaultTaskRepository {
            if (repository == null) {

                repository = DefaultTaskRepository(application)

                return repository as DefaultTaskRepository
            }

            return repository as DefaultTaskRepository
        }


    }

    suspend fun saveTask(task: Task) {

        withContext(ioDispatcher) {

            localDataSource.saveTask(task)
        }

    }

    fun getAllTask(): LiveData<List<Task>> {
        return localDataSource.getAllTasks()
    }
}