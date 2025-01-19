package com.example.vehicleinsuranceapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Claim {

    @PrimaryKey(autoGenerate = true)
    private int claimId;
    private String decription;
    private String status;
    private String dateSubmitted;
    private String dateUpdated;

    public Claim(String decription, String status,String dateSubmitted,String dateUpdated){

        // this.claimId = claimId;
        this.decription = decription;
        this.status = status;
        this.dateSubmitted = dateSubmitted;
        this.dateUpdated = dateUpdated;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getStatus(String newStatus) {
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Claim ID: " + claimId + "\nClaim Decription: " + decription + "\nStatus: " + status + "\nSubmitted on: " + dateSubmitted + "\nLast Updated: " + dateUpdated;
    }
}
