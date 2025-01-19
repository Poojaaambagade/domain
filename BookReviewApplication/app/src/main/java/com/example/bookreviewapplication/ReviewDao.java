package com.example.bookreviewapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReviewDao {

    @Insert
    void insert(Review review);

    @Query("SELECT * FROM reviews WHERE bookId = :bookId")
    List<Review> getReviewsForBook(int bookId);

    @Delete
    void delete(Review review);
}
