package com.example.notenow.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id :Int=0 ,
    val title :String,
    val description :String,
    val isCompleted :Boolean = false



){
    val isActive
        get() = !isCompleted
    val isEmpty
        get() =  title.isEmpty() || description.isEmpty()





}

