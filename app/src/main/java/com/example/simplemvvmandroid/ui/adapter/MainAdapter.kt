package com.example.simplemvvmandroid.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemvvmandroid.databinding.ItemBlogBinding
import com.example.simplemvvmandroid.model.main.Blog
import com.example.simplemvvmandroid.ui.main.MainViewModel

class MainAdapter(private val viewModel: MainViewModel, private var listBlog: List<Blog>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(private val binding: ItemBlogBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindView(blog: Blog){
            binding.tvSomething.text = blog.something.toString()
            binding.imgBtnTrash.setOnClickListener {
                viewModel.removeItem(blog)
                notifyDataSetChanged()
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemBlogBinding.inflate(layoutInflater,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val blog = listBlog[position]
        holder.bindView(blog)
    }

    override fun getItemCount(): Int {
        return listBlog.size
    }

}