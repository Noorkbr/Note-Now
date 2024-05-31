package com.example.notenow.addtask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.notenow.data.source.local.DefaultTaskRepository
import com.example.notenow.data.source.local.Task
import kotlinx.coroutines.launch

class AddTaskViewModel (application: Application) : AndroidViewModel(application) {
    val repository : DefaultTaskRepository=DefaultTaskRepository.getInstance(application)


    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()




    fun saveTask(){

        val currentTitle = title.value
        val currentDescription =description.value

        val task = Task(title=currentTitle.toString(), description = currentDescription.toString())
        crateTask(task)


    }

    private fun crateTask(task: Task) {
        viewModelScope.launch {
           repository.saveTask(task)
        }

    }
}