package com.gligamihai.traveljournal.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.gligamihai.traveljournal.ui.home.Trip;

import java.util.List;

public class TripRepository {

    private TripDao tripDao;
    private LiveData<List<Trip>> allTrips;

    TripRepository(Application application) {
        TripsDatabase db = TripsDatabase.getDatabase(application);
        tripDao = db.tripDao();
        allTrips = tripDao.getAllTrips();
    }

    LiveData<List<Trip>> getTrips() {
        return allTrips;
    }

    void insert(Trip trip) {
        TripsDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.insertTrip(trip);
        });
    }

}
