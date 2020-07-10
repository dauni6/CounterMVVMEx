package com.dontsu.countermvvmex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dontsu.countermvvmex.R
import com.dontsu.countermvvmex.databinding.ActivityMainBinding
import com.dontsu.countermvvmex.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        binding.viewModel = viewModel

        binding.fabAdd.setOnClickListener {
            viewModel.increase()
        }

        binding.fabRemove.setOnClickListener {
            viewModel.decrease()
        }

        /* viewModel.count.observe(this, Observer { count ->
            // UI 업데이트
            binding.counterTextView.text = viewModel.count.toString()
        })*/


    }


}