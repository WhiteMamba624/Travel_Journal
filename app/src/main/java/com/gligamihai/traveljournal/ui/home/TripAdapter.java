package com.gligamihai.traveljournal.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gligamihai.traveljournal.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripVIewHolder> {

    private final LayoutInflater layoutInflater;

    private List<Trip> trips;

    public TripAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NotNull
    @Override
    public TripVIewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item, parent, false);
        return new TripVIewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripVIewHolder holder, int position) {
        if(trips!=null) {
            Trip currentTrip = trips.get(position);
            holder.getTripName().setText(currentTrip.getName());
            holder.getTripDestination().setText(currentTrip.getDestination());
        }else{
            holder.getTripName().setText("No trip");
        }
    }

    void setTrips(List<Trip> trips) {
        this.trips = trips;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(trips!=null) {
            return trips.size();
        }
        else return 0;
    }
}
