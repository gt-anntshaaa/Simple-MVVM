package com.example.simplemvvmandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemvvmandroid.R
import com.example.simplemvvmandroid.databinding.ActivityMainBinding
import com.example.simplemvvmandroid.model.main.Blog
import com.example.simplemvvmandroid.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnSubmit.setOnClickListener {
            val text = binding.etSomething.toString()
            val blog = Blog(text)
            Toast.makeText(this, blog.something, Toast.LENGTH_SHORT).show()
            viewModel.addItem(blog)
            binding.rv.adapter?.notifyDataSetChanged()
        }

        viewModel.listBlog.observe(this, Observer {
            binding.rv.adapter = MainAdapter(viewModel,it)
        })
    }
}