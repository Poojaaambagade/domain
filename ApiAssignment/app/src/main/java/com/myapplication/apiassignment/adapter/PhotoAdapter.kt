package com.myapplication.apiassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapplication.apiassignment.R
import com.myapplication.apiassignment.model.Photo

class PhotoAdapter(private val photos: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_id: TextView = itemView.findViewById(R.id.img_id)
        val title: TextView = itemView.findViewById(R.id.title)
        val url: ImageView = itemView.findViewById(R.id.url)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val photo = photos[position]
        holder.img_id.text = photo.img_id.toString()
        holder.title.text = photo.title
        Glide.with(holder.itemView.context)
            .load(photo.url)
            .placeholder(R.drawable.img)
            .error(R.drawable.img)
            .into(holder.url)

    }

    override fun getItemCount() = photos.size
}
