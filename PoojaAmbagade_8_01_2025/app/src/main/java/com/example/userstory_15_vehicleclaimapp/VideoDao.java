package com.example.userstory_15_vehicleclaimapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface VideoDao {
    @Insert
    void insert(VideoEntity video);

    @Query("SELECT * FROM video_table")
    List<VideoEntity> getAllVideos();
}
