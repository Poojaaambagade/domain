package com.example.bookreviewapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =  {Book.class, Review.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract BookDao bookDao();
    public abstract ReviewDao reviewDao();

    public static synchronized AppDatabase getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "book_review_db").fallbackToDestructiveMigration().build();
        }
        return  instance;
    }
}
