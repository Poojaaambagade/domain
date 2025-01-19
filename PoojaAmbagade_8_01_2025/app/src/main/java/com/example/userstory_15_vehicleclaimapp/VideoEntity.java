package com.example.userstory_15_vehicleclaimapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "video_table")

public class VideoEntity {
    @PrimaryKey(autoGenerate = true)

    public int id;

    public String videoPath;

    public VideoEntity(String videoPath) {
        this.videoPath = videoPath;
    }

}
