package com.gligamihai.traveljournal.ui.home;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.gligamihai.traveljournal.EditActivity;
import com.gligamihai.traveljournal.R;
import com.gligamihai.traveljournal.TripInfoActivity;


public class TripVIewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener {


    public static final String CITY="city";
    private final ImageView tripImage;
    private final TextView tripName;
    private final TextView tripDestination;

    public TripVIewHolder(@NonNull View itemView){
        super(itemView);
        tripImage= itemView.findViewById(R.id.tripImage);
        tripName=itemView.findViewById(R.id.tripName);
        tripDestination=itemView.findViewById(R.id.tripDestination);
        itemView.setOnLongClickListener(this);
        itemView.setOnClickListener(this);
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

//        Log.i("TAG","Excursia a fost in "+textView.getText().toString());
//        Toast.makeText(v.getContext(), "Excursia a fost in "+textView.getText().toString(), Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public void onClick(View v){
        TextView textView= v.findViewById(R.id.tripDestination);
        Intent goToEditScreen=new Intent(v.getContext(), TripInfoActivity.class);
        goToEditScreen.putExtra(CITY,textView.getText().toString());
        v.getContext().startActivity(goToEditScreen);

    }
}
