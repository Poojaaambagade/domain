package com.example.elearningapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elearningapp.R
import com.example.elearningapp.entity.Course

class CourseAdapter(private val courseList: List<Course>, private val onDelete: (Course) -> Unit) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvCourseTitle)
        val description: TextView = view.findViewById(R.id.tvCourseDescription)
        val btnDelete: Button = view.findViewById(R.id.btnDeleteCourse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.title.text = course.title
        holder.description.text = course.description

        holder.btnDelete.setOnClickListener {
            onDelete(course)
        }
    }

    override fun getItemCount(): Int = courseList.size
}

//import android.content.Context
//import android.net.Uri
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import android.widget.VideoView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.elearningapp.R
//import com.example.elearningapp.entity.Course
//
//class CourseAdapter(
//    private var courses: List<Course>,
//    private val onDeleteClick: (Course) -> Unit
//) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
//
//    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val tvTitle: TextView = itemView.findViewById(R.id.tvCourseTitle)
//        val tvDescription: TextView = itemView.findViewById(R.id.tvCourseDescription)
//        val videoView: VideoView = itemView.findViewById(R.id.videoViewCourse)
//        val btnDelete: Button = itemView.findViewById(R.id.btnDeleteCourse)
//
//        fun bind(course: Course, context: Context) {
//            tvTitle.text = course.title
//            tvDescription.text = course.description
//
//            // Load and play video
//            if (course.filePath.isNotEmpty()) {
//                videoView.setVideoURI(Uri.parse(course.filePath))
//                videoView.setOnPreparedListener { it.start() }
//            }
//
//            btnDelete.setOnClickListener { onDeleteClick(course) }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_course, parent, false)
//        return CourseViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
//        holder.bind(courses[position], holder.itemView.context)
//    }
//
//    override fun getItemCount() = courses.size
//}
