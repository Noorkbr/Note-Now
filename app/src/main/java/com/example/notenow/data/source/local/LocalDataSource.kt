package com.example.notenow.data.source.local

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LocalDataSource(
    private val dao: TaskDao,
    private val ioDispatcher: CoroutineDispatcher=Dispatchers.IO

) : TaskDataSource {
    override suspend fun saveTask(task: Task) {
        withContext(ioDispatcher){
            dao.insertTask(task)

        }

    }

    override fun getAllTasks(): LiveData<List<Task>> {
      return dao.getAllTask()
    }


}


