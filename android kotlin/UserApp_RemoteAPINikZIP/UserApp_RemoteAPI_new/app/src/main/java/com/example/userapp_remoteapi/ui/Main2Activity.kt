package com.example.userapp_remoteapi.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.userapp_remoteapi.R
import com.example.userapp_remoteapi.adapter.UserAdapter
import com.example.userapp_remoteapi.api.RetrofitClient
import com.example.userapp_remoteapi.model.User

class Main2Activity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var todoBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        recyclerView = findViewById(R.id.recyclerView)
        todoBtn = findViewById(R.id.todoBtn);
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchUsers()
        todoBtn.setOnClickListener{
            val intent = Intent(this,TodoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchUsers() {
        //select * from users_baseurl
        RetrofitClient.instance.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    response.body()?.let { users ->
                        userAdapter = UserAdapter(users)
                        recyclerView.adapter = userAdapter
                    }
                } else {
                    Toast.makeText(
                        this@Main2Activity,
                        "Error: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@Main2Activity, "Failure: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

}