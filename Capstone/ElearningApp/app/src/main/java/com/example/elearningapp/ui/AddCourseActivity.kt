package com.example.elearningapp.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elearningapp.R
import com.example.elearningapp.database.AppDatabase
import com.example.elearningapp.entity.Course
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCourseActivity : AppCompatActivity() {

    private var selectedVideoUri: Uri? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        val etTitle = findViewById<EditText>(R.id.etCourseTitle)
        val etDescription = findViewById<EditText>(R.id.etCourseDescription)
        val btnUploadVideo = findViewById<Button>(R.id.btnUploadVideo)
        val btnAddCourse = findViewById<Button>(R.id.btnAddCourse)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Open file chooser to select video
        btnUploadVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "video/*" // Only allow video files
            startActivityForResult(intent, 100)
        }

        // Add course with title, description, and video URI

        btnAddCourse.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val description = etDescription.text.toString().trim()

            if (title.isNotEmpty() && description.isNotEmpty() && selectedVideoUri != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    val db = AppDatabase.getDatabase(this@AddCourseActivity)
                    db.courseDao().insertCourse(Course(title = title, description = description, filePath = selectedVideoUri.toString()))

                    runOnUiThread {
                        Toast.makeText(this@AddCourseActivity, "Course Added!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } else {
                Toast.makeText(this, "Fill all fields and upload a video!", Toast.LENGTH_SHORT).show()
            }

        }
        btnBack.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)  // Navigate to DashboardActivity
            startActivity(intent)
            finish()  // Optionally, finish the current activity
        }
    }

    // Handle video selection result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            selectedVideoUri = data?.data
            Toast.makeText(this, "Video Selected: ${selectedVideoUri?.path}", Toast.LENGTH_SHORT).show()
        }
    }


}