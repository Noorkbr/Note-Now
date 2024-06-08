package com.example.notenow.task_models


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notenow.R
import com.example.notenow.TaskListAdapter
import com.example.notenow.data.source.local.Task
import com.example.notenow.databinding.FragmentTaskBinding


class TaskFragment : Fragment(), TaskListAdapter.HandleClickListener {

    private lateinit var binding: FragmentTaskBinding
    private val viewModel by viewModels<TaskViewModel>()
    private lateinit var adapter: TaskListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_task, container, false)

        binding.taskViewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.allTask.observe(viewLifecycleOwner) { list ->
            adapter = TaskListAdapter(this, list)
            binding.recyclerView.adapter = adapter

        }

        binding.fabAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_tasks_fragment_dest_to_addTaskFragment)
        }

        return binding.root

    }

    override fun editTask(task: Task) {
        findNavController().navigate(
            TaskFragmentDirections.actionTasksFragmentDestToAddTaskFragment(task.id,task.title,task.description,task.isCompleted))
    }


}





