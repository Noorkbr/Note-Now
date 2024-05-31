package com.example.notenow.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notenow.R
import com.example.notenow.databinding.FragmentAddTaskBinding

class AddTaskFragment : Fragment() {

private lateinit var binding : FragmentAddTaskBinding
private val viewModel by viewModels<AddTaskViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater,container:ViewGroup?,savedInstanceState: Bundle?

    ): View? {


        binding=DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_task,container,false)
        binding.viewmodel=viewModel
        binding.lifecycleOwner=this.viewLifecycleOwner

        return binding.root
    }




}