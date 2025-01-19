package com.example.vehicleinsuranceapplicationnew;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClaimDao {

    @Insert
    void insertClaim(Claim claim);

    @Query("SELECT * FROM claim")
    List<Claim> getAllClaim();

    @Update
    void updateClaim(Claim claim);

    @Delete
    void deleteClaim(Claim claim);

    @Query("Select * from Claim where claimId=:id")
    Claim getClaimById(int id);

}
