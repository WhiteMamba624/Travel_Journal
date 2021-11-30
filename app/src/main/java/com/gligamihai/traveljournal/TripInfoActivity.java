package com.gligamihai.traveljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.gligamihai.traveljournal.retrofit.ApiClient;
import com.gligamihai.traveljournal.retrofit.ApiInterface;
import com.gligamihai.traveljournal.retrofit.WeatherData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gligamihai.traveljournal.ui.home.TripVIewHolder.CITY;

public class TripInfoActivity extends AppCompatActivity {

    TextView temperatureText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        temperatureText = findViewById(R.id.textTemperature);
        setContentView(R.layout.activity_trip_info);
        String city = getIntent().getStringExtra(CITY);
        Toast.makeText(this, "Trip was in " + city, Toast.LENGTH_SHORT).show();
        getWeatherData(city);
    }


    private void getWeatherData(String city) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        temperatureText=findViewById(R.id.textTemperature);
        Call<WeatherData> call = apiInterface.getWeatherData(city);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                try {
                    if (response.body() != null) {
                        temperatureText.setText("Temperatura in "+city+" "+String.valueOf(Math.round(Double.parseDouble(response.body().getWeather().getTemp())))+" C");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
             //   Log.d("DATA","Temperature in "+city+" "+String.valueOf(Math.round(Double.parseDouble(response.body().getWeather().getTemp()))));
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }
}