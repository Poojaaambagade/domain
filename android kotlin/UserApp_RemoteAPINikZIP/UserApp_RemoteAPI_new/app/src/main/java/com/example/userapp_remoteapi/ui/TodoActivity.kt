package com.example.userapp_remoteapi.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userapp_remoteapi.R
import com.example.userapp_remoteapi.adapter.TodoAdapter
import com.example.userapp_remoteapi.adapter.UserAdapter
import com.example.userapp_remoteapi.api.RetrofitClient
import com.example.userapp_remoteapi.model.Todo
import com.example.userapp_remoteapi.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoActivity : AppCompatActivity() {
    private lateinit var todo_recyclerView: RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        todo_recyclerView = findViewById(R.id.todo_recyclerView)
        todo_recyclerView.layoutManager = LinearLayoutManager(this)
        fetchTodo()

    }

    private fun fetchTodo() {
        //select * from users_baseurl
        RetrofitClient.instance.getTodos().enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if (response.isSuccessful) {
                    response.body()?.let { todos ->
                        todoAdapter = TodoAdapter(todos)
                        todo_recyclerView.adapter = todoAdapter
                    }
                } else {
                    Toast.makeText(
                        this@TodoActivity,
                        "Error: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Toast.makeText(this@TodoActivity, "Failure: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}