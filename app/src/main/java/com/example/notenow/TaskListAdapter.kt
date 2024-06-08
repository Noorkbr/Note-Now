package com.example.notenow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notenow.data.source.local.Task
import com.example.notenow.databinding.TaskItemLayoutBinding

class TaskListAdapter(private val handleClickListener: HandleClickListener ,private val list: List<Task>) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

        interface HandleClickListener{
            fun editTask(task: Task)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            TaskItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        list[position].let {task->
            holder.binding.apply {
                tvTitle.text = task.title

                root.setOnClickListener {
                    handleClickListener.editTask(task)
                }

            }
        }
    }

    inner class TaskViewHolder(val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}