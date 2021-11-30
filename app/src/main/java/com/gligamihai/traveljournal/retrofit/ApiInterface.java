package com.gligamihai.traveljournal.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?APPID=fb8606bc724b6e2f0a2144ed27f7bbf4&units=metric")
    Call<WeatherData> getWeatherData(@Query("q") String cityName);
}
