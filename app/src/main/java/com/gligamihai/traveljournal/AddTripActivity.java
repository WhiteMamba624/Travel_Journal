package com.gligamihai.traveljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Calendar;

public class AddTripActivity extends AppCompatActivity implements View.OnClickListener {

    final Calendar calendar = Calendar.getInstance();
    private SeekBar priceSeekbar;
    private EditText tripPrice;
    private EditText startTripDate;
    private EditText endTripDate;
    private Button buttonSetStartTripDate;
    private Button buttonSetEndTripDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        priceSeekbar = findViewById(R.id.tripPriceSlider);
        tripPrice = findViewById(R.id.tripPrice);
        startTripDate = findViewById(R.id.startTripDate);
        endTripDate = findViewById(R.id.endTripDate);
        buttonSetStartTripDate=findViewById(R.id.buttonStartDate);
        buttonSetEndTripDate=findViewById(R.id.buttonEndDate);
        buttonSetEndTripDate.setOnClickListener(this);
        buttonSetStartTripDate.setOnClickListener(this);
        handlingSeekbar();
    }

    private void handlingSeekbar() {
        priceSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tripPrice.setText("Price " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String dateText=((Button)view).getText().toString();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        if (dateText.equalsIgnoreCase("Start date")) {
                            startTripDate.setText(String.format("%d-%d-%d", dayOfMonth, monthOfYear + 1, year));
                        } else
                            if(dateText.equalsIgnoreCase("End date")){
                            endTripDate.setText(String.format("%d-%d-%d", dayOfMonth, monthOfYear + 1, year));
                        }
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void addTrip(View view) {

    }
}