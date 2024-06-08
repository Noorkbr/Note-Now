package com.example.notenow.task_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notenow.data.source.local.DefaultTaskRepository
import com.example.notenow.data.source.local.Task

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    val repository : DefaultTaskRepository = DefaultTaskRepository.getInstance(application)

    var allTask : LiveData<List<Task>> = repository.getAllTask()



}