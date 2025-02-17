package com.example.elearningapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.elearningapp.R
import com.example.elearningapp.database.AppDatabase
import com.example.elearningapp.entity.ExamQuestion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddExamQuestionActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exam_question)

        // Initialize the Room Database
        database = AppDatabase.getDatabase(this)

        // Find views
        val etQuestion = findViewById<EditText>(R.id.etQuestion)
        val etOption1 = findViewById<EditText>(R.id.etOption1)
        val etOption2 = findViewById<EditText>(R.id.etOption2)
        val etOption3 = findViewById<EditText>(R.id.etOption3)
        val etCorrectAnswer = findViewById<EditText>(R.id.etCorrectAnswer)
        val btnSaveQuestion = findViewById<Button>(R.id.btnSaveQuestion)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Save question button click listener
        btnSaveQuestion.setOnClickListener {
            val question = etQuestion.text.toString()
            val option1 = etOption1.text.toString()
            val option2 = etOption2.text.toString()
            val option3 = etOption3.text.toString()
            val correctAnswer = etCorrectAnswer.text.toString()

            if (question.isNotEmpty() && option1.isNotEmpty() && option2.isNotEmpty() && option3.isNotEmpty() && correctAnswer.isNotEmpty()) {
                // Create an ExamQuestion object
                val examQuestion = ExamQuestion(
                    question = question,
                    option1 = option1,
                    option2 = option2,
                    option3 = option3,
                    correctAnswer = correctAnswer
                )

                // Save the question to the database using coroutines
                CoroutineScope(Dispatchers.IO).launch {
                    database.examQuestionDao().insert(examQuestion)

                    // Show success message on the main thread
                    runOnUiThread {
                        Toast.makeText(this@AddExamQuestionActivity, "Question saved successfully!", Toast.LENGTH_SHORT).show()
                    }
                }

                // Clear input fields
                etQuestion.text.clear()
                etOption1.text.clear()
                etOption2.text.clear()
                etOption3.text.clear()
                etCorrectAnswer.text.clear()
            } else {
                // Show error message if any field is empty
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        btnBack.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)  // Navigate to DashboardActivity
            startActivity(intent)
            finish()  // Optionally, finish the current activity
        }
    }

}
