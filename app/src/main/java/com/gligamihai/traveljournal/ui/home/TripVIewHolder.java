package com.gligamihai.traveljournal.ui.home;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gligamihai.traveljournal.R;

public class TripVIewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

    private final ImageView tripImage;
    private final TextView tripName;
    private final TextView tripDestination;

    public TripVIewHolder(@NonNull View itemView){
        super(itemView);
        tripImage= itemView.findViewById(R.id.tripImage);
        tripName=itemView.findViewById(R.id.tripName);
        tripDestination=itemView.findViewById(R.id.tripDestination);
        itemView.setOnLongClickListener(this);
    }

    public ImageView getTripImage() {
        return tripImage;
    }

    public TextView getTripName() {
        return tripName;
    }

    public TextView getTripDestination() {
        return tripDestination;
    }

    @Override

    public boolean onLongClick(View v){
        Log.w("TAG","Long click apasat");
        return true;
    }
}
