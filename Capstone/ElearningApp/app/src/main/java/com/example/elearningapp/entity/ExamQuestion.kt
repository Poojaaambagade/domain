package com.example.elearningapp.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "exam_questions")
data class ExamQuestion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,

    val correctAnswer: String
)