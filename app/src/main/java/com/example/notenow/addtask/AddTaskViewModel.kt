package com.example.notenow.addtask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.notenow.R
import com.example.notenow.data.source.local.DefaultTaskRepository
import com.example.notenow.data.source.local.Task
import com.example.notenow.toTimedString
import kotlinx.coroutines.launch

class AddTaskViewModel(private val application: Application) : AndroidViewModel(application) {

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    private val repository: DefaultTaskRepository = DefaultTaskRepository.getInstance(application)

    private val _snackbarMsg = MutableLiveData<Int>()
    val snackbarMsg: LiveData<Int>
        get() = _snackbarMsg

    private val titleLength = 6




    fun saveTask() {
        val currentTitle = title.value
        val currentDescription = description.value

        if (isValidTask(currentTitle, currentDescription)) {

            val task =
                Task(
                    title = currentTitle.toTimedString(),
                    description = currentDescription.toTimedString()
                )

            createTask(task)
        }


    }

    private fun isValidTask(currentTitle: String?, currentDescription: String?): Boolean {
        if (currentTitle.isNullOrEmpty() || currentDescription.isNullOrEmpty()) {
            _snackbarMsg.postValue(R.string.empty_task_message)
            return false
        }

        if (currentTitle.toString().length < titleLength) {
            _snackbarMsg.postValue(R.string.title_must_be_6_char_or_more)
            return false
        }

        return true

    }

    private fun createTask(task: Task) {
        viewModelScope.launch {
            repository.saveTask(task)
        }

    }
}