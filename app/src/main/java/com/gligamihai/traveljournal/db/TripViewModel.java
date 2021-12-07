package com.gligamihai.traveljournal.db;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gligamihai.traveljournal.ui.home.Trip;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private TripRepository tripRepository;

    private LiveData<List<Trip>> allTrips;

    public TripViewModel (Application application) {
        super(application);
        tripRepository = new TripRepository(application);
        allTrips = tripRepository.getTrips();
    }




    public LiveData<List<Trip>> getAllTrips() {
        return allTrips;
    }

    public void insert(Trip trip) { tripRepository.insert(trip); }
}
