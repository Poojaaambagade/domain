package com.example.vehicleinsuranceapplicationnew;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Claim.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase  {

    public abstract ClaimDao claimDao();
    public  static AppDatabase instance;

    public static  synchronized  AppDatabase getInstance(Context context){

        if(instance == null){

            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "claim_database").build();   //getContext()
        }
        return instance;

    }
}
