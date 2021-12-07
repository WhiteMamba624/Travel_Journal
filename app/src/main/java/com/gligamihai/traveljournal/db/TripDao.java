package com.gligamihai.traveljournal.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.gligamihai.traveljournal.ui.home.Trip;

import java.util.List;

@Dao
public interface TripDao {

    @Insert
    void insertTrip(Trip trip);

    @Query("SELECT * from trips_table ORDER BY tripID DESC ")
    LiveData<List<Trip>> getAllTrips();
}
