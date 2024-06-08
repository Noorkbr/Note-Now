package com.example.notenow.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface TaskDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM task_table")
    fun getAllTask(): LiveData<List<Task>>

}