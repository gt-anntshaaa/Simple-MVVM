package com.example.simplemvvmandroid.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvmandroid.model.main.Blog

class MainViewModel : ViewModel() {
    var listBlog = MutableLiveData<List<Blog>>()
    private var newListBlog = arrayListOf<Blog>()

    fun addItem(blog: Blog){
        listBlog.apply {
            newListBlog.add(blog)
            listBlog.value = newListBlog
        }
    }

    fun removeItem(blog: Blog){
        listBlog.apply {
            newListBlog.remove(blog)
            listBlog.value = newListBlog
        }
    }
}