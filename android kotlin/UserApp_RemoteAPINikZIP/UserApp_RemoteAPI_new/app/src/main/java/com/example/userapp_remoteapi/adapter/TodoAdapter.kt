package com.example.userapp_remoteapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userapp_remoteapi.R
import com.example.userapp_remoteapi.model.Todo


class TodoAdapter(private val todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val completed: TextView = itemView.findViewById(R.id.completed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val todo = todos[position]
        holder.title.text = todo.title
        holder.completed.text = todo.completed
    }

    override fun getItemCount() = todos.size
}